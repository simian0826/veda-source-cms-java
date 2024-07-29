package tech.veda.cms.biz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import tech.veda.cms.biz.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author Bruno
 * @since 2024-07-29
 */
@Getter
@Setter
@TableName("t_project")
public class Project extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String type;

    private String location;

    private String title;

    private String subtitle;

    private String description;

    private String projectImages;
}
