package tech.veda.cms.biz.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.service.IProductCategoryPropertyConfigService;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-06-27
 */
@RestController
@RequestMapping("/productCategoryPropertyConfig")
public class ProductCategoryPropertyConfigController {

  @Autowired
  IProductCategoryPropertyConfigService productCategoryPropertyConfigService;

  @GetMapping("/list")
  public Result<JSONObject> findProductPropertyGroupByCategory() {

    return Result.succ(productCategoryPropertyConfigService.findProductPropertyGroupByCategory());
  }
}
