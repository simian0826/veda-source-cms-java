package tech.veda.cms.biz.service.vo;

import lombok.Builder;
import lombok.Data;
import tech.veda.cms.biz.entity.ProjectMaterial;

import java.util.List;

/**
 * @author lizhiying
 */
@Data
@Builder
public class ProjectVO {

  private Integer Id;

  private String type;

  private String title;

  private String location;


  private String subtitle;

  private String description;

  private List<String> projectImages;

  private List<ProjectMaterial> materials;
}
