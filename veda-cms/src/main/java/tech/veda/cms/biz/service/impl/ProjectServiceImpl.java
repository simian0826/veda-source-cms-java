package tech.veda.cms.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.veda.cms.biz.common.ProjectType;
import tech.veda.cms.biz.entity.Project;
import tech.veda.cms.biz.entity.ProjectMaterial;
import tech.veda.cms.biz.exception.ProjectException;
import tech.veda.cms.biz.mapper.ProjectMapper;
import tech.veda.cms.biz.service.IProjectMaterialService;
import tech.veda.cms.biz.service.IProjectService;
import tech.veda.cms.biz.service.dto.ProjectCreateDTO;
import tech.veda.cms.biz.service.dto.ProjectListRequestDTO;
import tech.veda.cms.biz.service.dto.ProjectUpdateDTO;
import tech.veda.cms.biz.service.vo.ProjectVO;
import tech.veda.cms.common.CommonResultStatus;
import tech.veda.cms.sys.service.dto.PageDTO;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bruno
 * @since 2024-07-26
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

  @Autowired
  IProjectMaterialService materialService;

  @Override
  public Boolean createProject(ProjectCreateDTO projectCreateDTO) {

    if(!projectCreateDTO.getType().equals(ProjectType.ON_GOING) && !projectCreateDTO.getType().equals(ProjectType.COMPLETED)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Project type error");

    }

    Project project = new Project();
    project.setType(projectCreateDTO.getType());
    project.setTitle(projectCreateDTO.getTitle());
    project.setLocation(projectCreateDTO.getLocation());
    project.setSubtitle(projectCreateDTO.getSubtitle());
    project.setDescription(projectCreateDTO.getDescription());
    project.setCreateDate(LocalDateTime.now());
    project.setProjectImages(StringUtils.join(projectCreateDTO.getProjectImages(), ","));

    if(!this.save(project)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Save project error");
    }

    List<ProjectMaterial> materials = this.getMaterialEntities(projectCreateDTO.getMaterials(), project.getId());
    materials.forEach(item -> item.setCreateDate(LocalDateTime.now()));
    if(!materialService.saveBatch(materials)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Save project material error");
    }

    return true;
  }

  @Override
  public Boolean updateProject(ProjectUpdateDTO projectUpdateDTO) {


    this.getOptById(projectUpdateDTO.getId()).orElseThrow(() -> new ProjectException(CommonResultStatus.SERVER_ERROR, "The project is not found which needs to update"));

    if(!projectUpdateDTO.getType().equals(ProjectType.ON_GOING) && !projectUpdateDTO.getType().equals(ProjectType.COMPLETED)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Project type error");

    }

    Project project = new Project();
    project.setId(projectUpdateDTO.getId());
    project.setType(projectUpdateDTO.getType());
    project.setTitle(projectUpdateDTO.getTitle());
    project.setLocation(projectUpdateDTO.getLocation());
    project.setSubtitle(projectUpdateDTO.getSubtitle());
    project.setDescription(projectUpdateDTO.getDescription());
    project.setUpdateDate(LocalDateTime.now());
    project.setProjectImages(StringUtils.join(projectUpdateDTO.getProjectImages(), ","));

    if(!this.saveOrUpdate(project)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Save project error");
    }

    QueryWrapper<ProjectMaterial> queryProjectMaterialWrapper = new QueryWrapper<>();
    queryProjectMaterialWrapper.eq("project_id", project.getId());

    List<Integer> materialIds = materialService.list(queryProjectMaterialWrapper).stream().map(item -> item.getId()).toList();
    materialService.removeBatchByIds(materialIds);

    List<ProjectMaterial> materials = this.getMaterialEntities(projectUpdateDTO.getMaterials(), project.getId());
    materials.forEach(item -> item.setCreateDate(LocalDateTime.now()));

    if(!materialService.saveBatch(materials)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Save project material error");
    }

    return true;
  }

  @Override
  public Boolean deleteProject(Integer id) {

    Project oldProject = this.getById(id);

    if(Objects.isNull(oldProject)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "The project is not found which needs to delete");
    }

    QueryWrapper<ProjectMaterial> queryProjectMaterialWrapper = new QueryWrapper<>();
    queryProjectMaterialWrapper.eq("project_id", id);
    if(materialService.remove(queryProjectMaterialWrapper)){
      if(!this.removeById(id)) {
        throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Delete project error");
      }
    }else {
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Delete project material error");

    }
//    List<Integer> materialIds = materialService.list(queryProjectMaterialWrapper).stream().map(item -> item.getId()).toList();
//    materialService.removeBatchByIds(materialIds);

    return true;
  }

  @Override
  public ProjectVO findProject(Integer id) {

    Project project = this.getById(id);
    if(Objects.isNull(project)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "The project is not found");
    }
    QueryWrapper<ProjectMaterial> queryProjectMaterialWrapper = new QueryWrapper<>();
    queryProjectMaterialWrapper.eq("project_id", id);
    List<ProjectMaterial> materials = materialService.list(queryProjectMaterialWrapper);

    return ProjectVO.builder()
      .Id(project.getId())
      .type(project.getType())
      .title(project.getTitle())
      .subtitle(project.getSubtitle())
      .description(project.getDescription())
      .location(project.getLocation())
      .projectImages(Arrays.asList(project.getProjectImages().split(",")))
      .materials(materials)
      .build();

  }

  @Override
  public PageDTO<ProjectVO> findProjects(ProjectListRequestDTO projectListRequest) {



    Page<Project> page = new Page(projectListRequest.getPage(), projectListRequest.getPageSize());

    QueryWrapper<Project> queryProjectWrapper = new QueryWrapper<>();

    if(!"".equals(projectListRequest.getType())){
      if(!projectListRequest.getType().equals(ProjectType.ON_GOING) && !projectListRequest.getType().equals(ProjectType.COMPLETED)){
        throw new ProjectException(CommonResultStatus.SERVER_ERROR, "Project type error");
      }
      queryProjectWrapper.eq("type", projectListRequest.getType());

    }


    IPage<Project> projectPage = getBaseMapper().selectPage(page, queryProjectWrapper);

    List<Project> projectList = this.list(projectPage, queryProjectWrapper);

    List<ProjectVO> projectVOList = projectList.stream().map(project -> {

      QueryWrapper<ProjectMaterial> queryMaterialWrapper = new QueryWrapper<>();
      queryMaterialWrapper.eq("project_id", project.getId());

      List<ProjectMaterial> materials = materialService.list(queryMaterialWrapper);

      return ProjectVO.builder()
        .Id(project.getId())
        .type(project.getType())
        .title(project.getTitle())
        .subtitle(project.getSubtitle())
        .description(project.getDescription())
        .location(project.getLocation())
        .projectImages(Arrays.asList(project.getProjectImages().split(",")))
        .materials(materials)
        .build();
    }).toList();

    PageDTO<ProjectVO> result =  new PageDTO(projectVOList, this.count(queryProjectWrapper));
    return result;
  }


  List<ProjectMaterial> getMaterialEntities(List<ProjectMaterial> materials, Integer projectId){
   return materials.stream().map(item -> {
      ProjectMaterial material = new ProjectMaterial();
      material.setProjectId(projectId);
      material.setTitle(item.getTitle());
      material.setSubtitle(item.getSubtitle());
      material.setTaxType(item.getTaxType());
      material.setImage(item.getImage());
      return material;
    }).toList();

  }
}
