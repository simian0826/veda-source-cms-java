package tech.veda.cms.biz.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import tech.veda.cms.biz.common.DictType;
import tech.veda.cms.biz.entity.Dict;
import tech.veda.cms.biz.entity.ProductCategoryPropertyConfig;
import tech.veda.cms.biz.mapper.ProductCategoryPropertyConfigMapper;
import tech.veda.cms.biz.service.IDictService;
import tech.veda.cms.biz.service.IProductCategoryPropertyConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-27
 */
@Service
public class ProductCategoryPropertyConfigServiceImpl extends ServiceImpl<ProductCategoryPropertyConfigMapper, ProductCategoryPropertyConfig> implements IProductCategoryPropertyConfigService {

  @Autowired
  IDictService dictService;

  @Override
  public JSONObject findProductPropertyGroupByCategory() {

    QueryWrapper<Dict> queryProductCategoryWrapper = new QueryWrapper<>();
    queryProductCategoryWrapper.eq("type", DictType.PRODUCT_CATEGORY);

    List<Dict> productCategories = dictService.list(queryProductCategoryWrapper);
    List<String> productCategoryNames = new ArrayList<>(new HashSet<>(productCategories.stream().map(item -> item.getLabel()).toList()));

    JSONObject result = new JSONObject();
    productCategoryNames.stream().forEach(productCategoryName -> {
      QueryWrapper<ProductCategoryPropertyConfig> queryProductCategoryConfigWrapper = new QueryWrapper<>();
      queryProductCategoryConfigWrapper.eq("category", productCategoryName);
      result.put(productCategoryName, this.list(queryProductCategoryConfigWrapper).stream().map(item -> item.getPropertyName()).toList());
    });

    return result;
  }
}
