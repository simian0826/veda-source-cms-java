package tech.veda.cms.biz.service.dto;

import lombok.Data;
import tech.veda.cms.biz.entity.ProjectMaterial;

import java.util.List;

/**
 * @author lizhiying
 */

@Data
public class ProjectCreateDTO {


  private String type;

  private String location;


  private String title;

  private String subtitle;

  private String description;

  private List<String> projectImages;

  private List<ProjectMaterial> materials;
}
