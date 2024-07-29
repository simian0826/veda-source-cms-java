package tech.veda.cms.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.service.IProjectService;
import tech.veda.cms.biz.service.dto.*;
import tech.veda.cms.biz.service.vo.ProductVO;
import tech.veda.cms.biz.service.vo.ProjectVO;
import tech.veda.cms.sys.service.dto.PageDTO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bruno
 * @since 2024-07-26
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

  @Autowired
  IProjectService projectService;

  @PostMapping("/create")
  public Result<Boolean> CreateProduct(@RequestBody ProjectCreateDTO projectCreateDTO) {

    return Result.succ(projectService.createProject(projectCreateDTO));
  }

  @PostMapping("/update")
  public Result<Boolean> UpdateProduct(@RequestBody ProjectUpdateDTO projectUpdateDTO) {

    return Result.succ(projectService.updateProject(projectUpdateDTO));
  }


  @PostMapping("/delete/{id}")
  public Result<Boolean> UpdateProduct(@PathVariable Integer id) {

    return Result.succ(projectService.deleteProject(id));
  }

  @GetMapping("/detail/{id}")
  public Result<ProjectVO> findProject(@PathVariable Integer id) {

    return Result.succ(projectService.findProject(id));
  }


  @GetMapping("/list")
  public Result<PageDTO<ProjectVO>> findProjects(@RequestParam(defaultValue = "", required = false) String type, @RequestParam Integer page, @RequestParam Integer pageSize) {
    ProjectListRequestDTO projectListRequest = new ProjectListRequestDTO();
    projectListRequest.setType(type);
    projectListRequest.setPage(page);
    projectListRequest.setPageSize(pageSize);
    return Result.succ(projectService.findProjects(projectListRequest));
  }






}
