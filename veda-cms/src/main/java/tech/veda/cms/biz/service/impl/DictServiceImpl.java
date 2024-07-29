package tech.veda.cms.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import tech.veda.cms.biz.common.DictType;
import tech.veda.cms.biz.mapper.DictMapper;
import tech.veda.cms.biz.entity.Dict;
import tech.veda.cms.biz.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.veda.cms.biz.service.vo.ProductCategoryDictVO;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

  @Override
  public List<ProductCategoryDictVO> findProductCategory() {

    QueryWrapper<Dict> queryProductCategoryWrapper = new QueryWrapper<>();
    queryProductCategoryWrapper.eq("type", DictType.PRODUCT_CATEGORY);
    return this.list(queryProductCategoryWrapper).stream().map(item -> ProductCategoryDictVO.builder().label(item.getLabel()).value(item.getValue()).build()).toList();
  }
}
