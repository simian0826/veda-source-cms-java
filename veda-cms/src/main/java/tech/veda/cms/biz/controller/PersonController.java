package tech.veda.cms.biz.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.entity.Person;
import tech.veda.cms.biz.service.IPersonService;
import tech.veda.cms.biz.service.dto.PersonCreateDTO;
import tech.veda.cms.biz.service.dto.PersonUpdateDTO;

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
  IPersonService leaderService;

  @PostMapping("/create")
  public Result<Boolean> createLeader(@RequestBody @NotNull PersonCreateDTO leaderDTO) {

    return Result.succ(leaderService.createPerson(leaderDTO));
  }
  @PostMapping("/update")
  public Result<Boolean> updateLeader(@RequestBody @NotNull PersonUpdateDTO leaderDTO) {

    return Result.succ(leaderService.updatePerson(leaderDTO));
  }


  @GetMapping("/find/{id}")
  public Result<Person> findPerson(@PathVariable Integer id) {

    return Result.succ(leaderService.findPerson(id));
  }


}
