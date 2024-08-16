package tech.veda.cms.biz.service;

import org.springframework.transaction.annotation.Transactional;
import tech.veda.cms.biz.entity.Product;
import tech.veda.cms.biz.service.dto.ProductCreateRequestDTO;
import tech.veda.cms.biz.service.dto.ProductUpdateRequestDTO;
import tech.veda.cms.biz.service.vo.ProductVO;
import com.baomidou.mybatisplus.extension.service.IService;
import tech.veda.cms.biz.service.dto.ProductListRequestDTO;
import tech.veda.cms.sys.service.dto.PageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-22
 */
public interface IProductService extends IService<Product> {

  /**
   * find product list
   * @param productListRequest
   * @return
   */
    PageDTO<ProductVO> findProducts(ProductListRequestDTO productListRequest);

  /**
   * find product list
   * @param productId
   * @return
   */
  ProductVO findProduct(Integer productId);

  ProductVO findProductCMS(Integer productId);


  /**
   * create a new product
   * @param ProductCreateRequest
   * @return Boolean
   */
    @Transactional(rollbackFor = Exception.class)
    Boolean createProduct(ProductCreateRequestDTO ProductCreateRequest);

  /**
   * update a product
   * @param productUpdateRequest
   * @return Boolean
   */
    @Transactional(rollbackFor = Exception.class)
    Boolean updateProduct(ProductUpdateRequestDTO productUpdateRequest);



    @Transactional(rollbackFor = Exception.class)
    Boolean deleteProduct(Integer id);



}
