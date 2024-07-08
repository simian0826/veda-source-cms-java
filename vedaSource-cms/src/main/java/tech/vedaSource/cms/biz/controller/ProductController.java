package tech.vedaSource.cms.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import tech.vedaSource.cms.biz.service.IProductService;
import tech.vedaSource.cms.biz.service.dto.ProductCreateRequestDTO;
import tech.vedaSource.cms.biz.service.dto.ProductListRequestDTO;
import tech.vedaSource.cms.biz.service.dto.ProductUpdateRequestDTO;
import tech.vedaSource.cms.biz.service.vo.ProductVO;
import tech.vedaSource.cms.sys.service.dto.PageDTO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-06-22
 */
@Controller
@RequestMapping("/product")
public class ProductController {
  @Autowired
  IProductService productService;

  @GetMapping("/list")
  public ResponseEntity<PageDTO<ProductVO>> findProducts(@RequestBody ProductListRequestDTO productListRequest) {

    return ResponseEntity.ok(productService.findProducts(productListRequest));
  }


  @GetMapping("/{id}")
  public ResponseEntity<ProductVO> findProducts(@PathVariable Integer id) {

    return ResponseEntity.ok(productService.findProduct(id));
  }


  @PostMapping("/create")
  public ResponseEntity<Boolean> CreateProduct(@RequestBody ProductCreateRequestDTO productCreateRequest) {

    return ResponseEntity.ok(productService.createProduct(productCreateRequest));
  }

  @PostMapping("/update")
  public ResponseEntity<Boolean> updateProduct(@RequestBody ProductUpdateRequestDTO productUpdateRequest) {

    return ResponseEntity.ok(productService.updateProduct(productUpdateRequest));
  }

  @PostMapping("/delete/{id}")
  public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id) {

    return ResponseEntity.ok(productService.deleteProduct(id));
  }
}


