package tech.veda.cms.biz.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.entity.Person;
import tech.veda.cms.biz.service.IPersonService;
import tech.veda.cms.biz.service.dto.PageRequestDTO;
import tech.veda.cms.biz.service.dto.PersonCreateDTO;
import tech.veda.cms.biz.service.dto.PersonUpdateDTO;
import tech.veda.cms.biz.service.dto.ProductListRequestDTO;
import tech.veda.cms.biz.service.vo.ProductVO;
import tech.veda.cms.sys.service.dto.PageDTO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  IPersonService personService;

  @PostMapping("/create")
  public Result<Boolean> createPerson(@RequestBody @NotNull PersonCreateDTO leaderDTO) {

    return Result.succ(personService.createPerson(leaderDTO));
  }
  @PostMapping("/update")
  public Result<Boolean> updatePerson(@RequestBody @NotNull PersonUpdateDTO leaderDTO) {

    return Result.succ(personService.updatePerson(leaderDTO));
  }

  @PostMapping("/delete/{id}")
  public Result<Boolean> deletePerson(@PathVariable Integer id) {

    return Result.succ(personService.deletePerson(id));
  }


  @GetMapping("/find/{id}")
  public Result<Person> findPerson(@PathVariable Integer id) {

    return Result.succ(personService.findPerson(id));
  }


  @GetMapping("/list")
  public Result<PageDTO<Person>> findProducts(@RequestParam Integer page, @RequestParam Integer pageSize) {
    PageRequestDTO pageRequestDTO = new ProductListRequestDTO();
    pageRequestDTO.setPage(page);
    pageRequestDTO.setPageSize(pageSize);
    return Result.succ(personService.findPeople(pageRequestDTO));
  }

}
