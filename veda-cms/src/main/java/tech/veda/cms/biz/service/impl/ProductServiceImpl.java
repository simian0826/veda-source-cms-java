package tech.veda.cms.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.veda.cms.biz.common.ProductPropertyType;
import tech.veda.cms.biz.entity.*;
import tech.veda.cms.biz.exception.ProductException;
import tech.veda.cms.biz.mapper.ProductMapper;
import tech.veda.cms.biz.mapper.ProductPropertyMapper;
import tech.veda.cms.biz.service.*;
import tech.veda.cms.biz.service.dto.*;
import tech.veda.cms.biz.service.vo.ProductPropertyItemVO;
import tech.veda.cms.biz.service.vo.ProductPropertyVO;
import tech.veda.cms.biz.service.vo.ProductVO;
import tech.veda.cms.common.CommonResultStatus;
import tech.veda.cms.sys.service.dto.PageDTO;

import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-22
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {


  @Autowired
  ProductMapper productMapper;

  @Autowired
  ProductPropertyMapper productPropertyMapper;

  @Autowired
  IProductPropertyService productPropertyService;

  @Autowired
  IProductPropertyItemService productPropertyItemService;

  @Autowired
  IDictService dictService;

  @Autowired
  IProductCategoryPropertyConfigService productCategoryPropertyConfigService;


  @Override
  public PageDTO<ProductVO> findProducts(@NotNull ProductListRequestDTO productListRequest) {


    Page<Product> page = new Page<>(productListRequest.getPage(), productListRequest.getPageSize());

    QueryWrapper<Product> queryProductWrapper = new QueryWrapper<>();
    if (!productListRequest.getCategory().equals("") && !productListRequest.getCategory().equals(null)){
      queryProductWrapper.eq("category",productListRequest.getCategory());
    }
    IPage<Product> productPage = getBaseMapper().selectPage(page, queryProductWrapper);

    List<ProductVO> productVOs =  this.list(productPage, queryProductWrapper).stream().map(product -> {

      QueryWrapper<ProductProperty> queryProductPropertyWrapper = new QueryWrapper<>();
      queryProductPropertyWrapper.eq("product_id", product.getId());
      queryProductPropertyWrapper.eq("status", "1");
      List<ProductPropertyVO> productPropertyVOs = productPropertyService.list(queryProductPropertyWrapper)
          .stream().map(productProperty -> {
            QueryWrapper<ProductPropertyItem> queryProductPropertyItemWrapper = new QueryWrapper<>();
          queryProductPropertyItemWrapper.eq("product_property_id", productProperty.getId());
          queryProductPropertyItemWrapper.eq("status", "1");
            List<ProductPropertyItemVO> ProductPropertyItemVOs = productPropertyItemService.list(queryProductPropertyItemWrapper)
              .stream().map(productPropertyItem ->
                              ProductPropertyItemVO.builder()
                                .label(productPropertyItem.getLabel())
                                .value(productPropertyItem.getValue()).build()).toList();

            return ProductPropertyVO.builder().name(productProperty.getName()).items(ProductPropertyItemVOs).build();

          }).toList();
      return ProductVO.builder()
        .id(product.getId())
        .category(product.getCategory())
        .name(product.getName())
        .description(product.getDescription())
        .imgs(Arrays.asList(product.getImgs().split(",")))
        .certificate(Arrays.asList(product.getCertificate().split(",")))
        .properties(productPropertyVOs).build();

    }).toList();

    PageDTO<ProductVO> result = new PageDTO(productVOs, this.count(queryProductWrapper));
    return result;
  }

  /**
   * find product list
   *
   * @param productId
   * @return
   */
  @Override
  public ProductVO findProduct(Integer productId) {

    Product product = this.getById(productId);
    if(Objects.isNull(product)){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "Can't find that product");

    }

    QueryWrapper<ProductProperty> queryProductPropertyWrapper = new QueryWrapper<>();
    queryProductPropertyWrapper.eq("product_id", product.getId());
    List<ProductPropertyVO> productPropertyVOs = productPropertyService.list(queryProductPropertyWrapper)
        .stream().map(productProperty -> {
          QueryWrapper<ProductPropertyItem> queryProductPropertyItemWrapper = new QueryWrapper<>();
        queryProductPropertyItemWrapper.eq("product_property_id", productProperty.getId());
          List<ProductPropertyItemVO> ProductPropertyItemVOs = productPropertyItemService.list(queryProductPropertyItemWrapper)
            .stream().map(productPropertyItem ->
                            ProductPropertyItemVO.builder()
                              .label(productPropertyItem.getLabel())
                              .value(productPropertyItem.getValue()).build()).toList();
          return ProductPropertyVO.builder().name(productProperty.getName()).items(ProductPropertyItemVOs).build();
        }).toList();

    return ProductVO.builder()
      .id(product.getId())
      .category(product.getCategory())
      .name(product.getName())
      .description(product.getDescription())
      .imgs(Arrays.asList(product.getImgs().split(",")))
      .certificate(Arrays.asList(product.getCertificate().split(",")))
      .properties(productPropertyVOs).build();


  }


  @Override
  public Boolean createProduct(@NotNull ProductCreateRequestDTO productCreateRequest) {

    Product product = new Product();

    QueryWrapper<Dict> queryProductCategoryWrapper = new QueryWrapper<>();
    queryProductCategoryWrapper.eq("type", "product category");

    product.setName(productCreateRequest.getName());

    if(!dictService.list(queryProductCategoryWrapper).stream().map(item -> item.getValue()).toList().contains(productCreateRequest.getCategory())){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "Invalid value of product category");
    }
    product.setCategory(productCreateRequest.getCategory());
    product.setDescription(productCreateRequest.getDescription());
    product.setImgs(StringUtils.join(productCreateRequest.getImgs(), ","));
    product.setCertificate(StringUtils.join(productCreateRequest.getCertificate(), ","));
    product.setCreateDate(LocalDateTime.now());
    if(!this.save(product)){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "Save product error");
    }
    QueryWrapper<ProductCategoryPropertyConfig> queryProductCategoryPropertyConfigWrapper = new QueryWrapper<>();
    queryProductCategoryPropertyConfigWrapper.eq("category", product.getCategory());

    List<String> productPropertyNameList = productCategoryPropertyConfigService.list(queryProductCategoryPropertyConfigWrapper).stream().map(item -> item.getPropertyName()).toList();
    if(productCreateRequest.getProperties() != null && productCreateRequest.getProperties().size() > 0){
      productCreateRequest.getProperties().forEach(productPropertyDTO -> this.saveOrUpdateProductProperty(productPropertyDTO, product, productPropertyNameList, "save", ProductPropertyType.ORIGINAL));
    }
    if(productCreateRequest.getAdditionalProperties() != null && productCreateRequest.getAdditionalProperties().size() > 0){
      productCreateRequest.getAdditionalProperties().forEach(productPropertyDTO -> this.saveOrUpdateProductProperty(productPropertyDTO, product, productPropertyNameList, "save", ProductPropertyType.ADDITIONAL));

    }
    return true;
  }



  @Override
  public Boolean updateProduct(@NotNull ProductUpdateRequestDTO productUpdateRequest) {

    Product oldProduct = this.getById(productUpdateRequest.getId());

    if(Objects.isNull(oldProduct)){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "The product is not found which needs to update");
    }
    QueryWrapper<Dict> queryProductCategoryWrapper = new QueryWrapper<>();
    queryProductCategoryWrapper.eq("type", "product category");
    Product product = new Product();
    product.setId(productUpdateRequest.getId());
    product.setName(productUpdateRequest.getName());

    if(!dictService.list(queryProductCategoryWrapper).stream().map(item -> item.getValue()).toList().contains(productUpdateRequest.getCategory())){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "Invalid value of product category");
    }


    //
    product.setCategory(productUpdateRequest.getCategory());
    product.setDescription(productUpdateRequest.getDescription());
    product.setImgs(StringUtils.join(productUpdateRequest.getImgs(), ","));
    product.setCertificate(StringUtils.join(productUpdateRequest.getCertificate(), ","));
    product.setUpdateDate(LocalDateTime.now());
    if(!this.saveOrUpdate(product)){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "Update product error");
    }

    //select property config in specific product category, so that can acknowledge which original properties a product has
    QueryWrapper<ProductCategoryPropertyConfig> queryProductCategoryPropertyConfigWrapper = new QueryWrapper<>();
    queryProductCategoryPropertyConfigWrapper.eq("category", product.getCategory());
    List<String> productPropertyNameList =  productCategoryPropertyConfigService.list(queryProductCategoryPropertyConfigWrapper).stream().map(item -> item.getPropertyName()).toList();


    if(productUpdateRequest.getProperties() != null && productUpdateRequest.getProperties().size() > 0){
      productUpdateRequest.getProperties().forEach(productPropertyDTO -> this.saveOrUpdateProductProperty(productPropertyDTO, product, productPropertyNameList, "update", ProductPropertyType.ORIGINAL));
    }
    if(productUpdateRequest.getAdditionalProperties() != null && productUpdateRequest.getAdditionalProperties().size() > 0){
      productUpdateRequest.getAdditionalProperties().forEach(productPropertyDTO -> this.saveOrUpdateProductProperty(productPropertyDTO, product, productPropertyNameList, "update", ProductPropertyType.ADDITIONAL));

    }
    return true;
  }

  @Override
  public Boolean deleteProduct(Integer id) {
    QueryWrapper<ProductProperty> queryProductPropertyWrapper = new QueryWrapper<>();
    queryProductPropertyWrapper.eq("product_id", id);
    List<ProductProperty> productProperties = productPropertyService.list(queryProductPropertyWrapper);
    List<Integer> productPropertyItemIds = new ArrayList<>();

    //remove product property
    boolean removeProductPropertyFlag = productPropertyService.removeBatchByIds(productProperties.stream().map(productProperty -> {
      QueryWrapper<ProductPropertyItem> queryProductPropertyItemWrapper = new QueryWrapper<>();
      queryProductPropertyItemWrapper.eq("product_property_id", productProperty.getId());
      productPropertyItemService.list(queryProductPropertyItemWrapper).forEach(item -> productPropertyItemIds.add(item.getId()));
      return productProperty.getId();
    }).toList());

    if(!removeProductPropertyFlag){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "remove product property error");
    }
    if(!productPropertyItemService.removeBatchByIds(productPropertyItemIds)){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "remove product property item error");
    }

    return this.removeById(id);
  }


  /**
   *
   * @param operateType save, update
   * */
  private void saveOrUpdateProductProperty(ProductPropertyDTO productPropertyDTO, Product product, List<String> productPropertyNameList, String operateType, @NotNull String propertyType){
    if(propertyType.equals(ProductPropertyType.ORIGINAL) && !productPropertyNameList.contains(productPropertyDTO.getName())){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "There is not such property in product with category" + product.getCategory());
    }

    ProductProperty productProperty = new ProductProperty();
    productProperty.setProductId(product.getId());
    productProperty.setName(productPropertyDTO.getName());
    productProperty.setCreateDate(LocalDateTime.now());
    productProperty.setType(propertyType);

    // if the operation type is update
    if("update".equals(operateType) ){
      //select product properties in this product
      QueryWrapper<ProductProperty> queryProductPropertyWrapper = new QueryWrapper<>();
      queryProductPropertyWrapper.eq("product_id", product.getId());
      queryProductPropertyWrapper.eq("status", "1");
      List<ProductProperty> productProperties = productPropertyService.list(queryProductPropertyWrapper);

      //find that this product property is existed, so that just update the original product property
      Optional<ProductProperty> matchedProductProperty = productProperties.stream().filter(item -> item.getName().equals(productPropertyDTO.getName())).findFirst();

      if(matchedProductProperty.isPresent()){
        productProperty.setId(matchedProductProperty.get().getId());

        //remove all property items in each property
        QueryWrapper<ProductPropertyItem> removeProductPropertyItemWrapper = new QueryWrapper<>();
        removeProductPropertyItemWrapper.eq("product_property_id",matchedProductProperty.get().getId());
        removeProductPropertyItemWrapper.eq("status", "1");
        productPropertyItemService.remove(removeProductPropertyItemWrapper);
      }


    }

    if(!productPropertyService.saveOrUpdate(productProperty)){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "Save product property error");
    }

    productPropertyDTO.getItems().forEach(item -> this.saveProductPropertyItem(item, productProperty));

  }

  private void saveProductPropertyItem(ProductPropertyItemDTO productPropertyItemDTO, @NotNull ProductProperty productProperty){

    ProductPropertyItem productPropertyItem = new ProductPropertyItem();
    productPropertyItem.setProductPropertyId(productProperty.getId());
    productPropertyItem.setLabel(productPropertyItemDTO.getLabel());
    productPropertyItem.setValue(productPropertyItemDTO.getValue());
    productPropertyItem.setCreateDate(LocalDateTime.now());

    if(!productPropertyItemService.save(productPropertyItem)){
      throw new ProductException(CommonResultStatus.SERVER_ERROR, "Save product property error");
    }
  }


}
