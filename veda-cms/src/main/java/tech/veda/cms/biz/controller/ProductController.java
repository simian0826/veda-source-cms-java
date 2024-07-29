package tech.veda.cms.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.service.vo.ProductVO;
import tech.veda.cms.biz.service.IProductService;
import tech.veda.cms.biz.service.dto.ProductCreateRequestDTO;
import tech.veda.cms.biz.service.dto.ProductListRequestDTO;
import tech.veda.cms.biz.service.dto.ProductUpdateRequestDTO;
import tech.veda.cms.sys.service.dto.PageDTO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-06-22
 */
@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  IProductService productService;

  @GetMapping("/list")
  public Result<PageDTO<ProductVO>> findProducts(@RequestParam String category, @RequestParam Integer page, @RequestParam Integer pageSize) {
    ProductListRequestDTO productListRequest = new ProductListRequestDTO();
    productListRequest.setCategory(category);
    productListRequest.setPage(page);
    productListRequest.setPageSize(pageSize);
    return Result.succ(productService.findProducts(productListRequest));
  }


  @GetMapping("/detail/{id}")
  public Result<ProductVO> findProducts(@PathVariable Integer id) {

    return Result.succ(productService.findProduct(id));
  }


  @PostMapping("/create")
  public Result<Boolean> CreateProduct(@RequestBody ProductCreateRequestDTO productCreateRequest) {

    return Result.succ(productService.createProduct(productCreateRequest));
  }

  @PostMapping("/update")
  public Result<Boolean> updateProduct(@RequestBody ProductUpdateRequestDTO productUpdateRequest) {

    return Result.succ(productService.updateProduct(productUpdateRequest));
  }

  @PostMapping("/delete/{id}")
  public Result<Boolean> deleteProduct(@PathVariable Integer id) {

    return Result.succ(productService.deleteProduct(id));
  }
}


