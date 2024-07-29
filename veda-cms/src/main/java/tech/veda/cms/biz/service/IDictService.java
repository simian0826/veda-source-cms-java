package tech.veda.cms.biz.service;

import tech.veda.cms.biz.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import tech.veda.cms.biz.service.vo.ProductCategoryDictVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
public interface IDictService extends IService<Dict> {
  
  List<ProductCategoryDictVO> findProductCategory();
}
