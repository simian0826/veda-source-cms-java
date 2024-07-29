package tech.veda.cms.biz.service.vo;

import lombok.Builder;
import lombok.Data;
import tech.veda.cms.biz.entity.Person;
import tech.veda.cms.biz.service.dto.AboutUsQualityItem;

import java.util.List;

/**
 * @author lizhiying
 */
@Data
@Builder
public class AboutUsVO {
  private List<AboutUsQualityItem> qualityItems;
  private List<Person> teamMembers;
  private String needHelpHeader;
  private String needHelpDesc;

}

