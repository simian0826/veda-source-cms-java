package tech.veda.cms.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.service.IDictService;
import tech.veda.cms.biz.service.vo.ProductCategoryDictVO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-06-21
 */
@RestController
@RequestMapping("/dict")
public class DictController {

  @Autowired
  IDictService dictService;

  @GetMapping("/findProductCategory")
  public Result<List<ProductCategoryDictVO>> findHeroSections() {

    return Result.succ(dictService.findProductCategory());
  }


}
