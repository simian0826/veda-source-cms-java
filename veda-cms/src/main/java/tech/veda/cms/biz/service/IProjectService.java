package tech.veda.cms.biz.service;

import org.springframework.transaction.annotation.Transactional;
import tech.veda.cms.biz.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;
import tech.veda.cms.biz.service.dto.ProductListRequestDTO;
import tech.veda.cms.biz.service.dto.ProjectCreateDTO;
import tech.veda.cms.biz.service.dto.ProjectListRequestDTO;
import tech.veda.cms.biz.service.dto.ProjectUpdateDTO;
import tech.veda.cms.biz.service.vo.ProjectVO;
import tech.veda.cms.sys.service.dto.PageDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bruno
 * @since 2024-07-26
 */
public interface IProjectService extends IService<Project> {

  @Transactional(rollbackFor = Exception.class)
  Boolean createProject(ProjectCreateDTO projectCreateDTO);

  @Transactional(rollbackFor = Exception.class)
  Boolean updateProject(ProjectUpdateDTO projectUpdateDTO);

  @Transactional(rollbackFor = Exception.class)
  Boolean deleteProject(Integer id);

  ProjectVO findProject(Integer id);

  PageDTO<ProjectVO> findProjects(ProjectListRequestDTO projectListRequest);
}
