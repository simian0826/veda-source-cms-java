package tech.veda.cms.biz.service.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lizhiying
 */
@Data
public class AboutUsDTO {
  private List<AboutUsQualityItem> qualityItems;
  private List<Integer> teamMembers;
  private String needHelpHeader;
  private String needHelpDesc;
}


