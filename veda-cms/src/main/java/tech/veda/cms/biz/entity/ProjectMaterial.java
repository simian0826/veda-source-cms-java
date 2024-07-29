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
@TableName("t_project_material")
public class ProjectMaterial extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer projectId;

    private String title;

    private String subtitle;

    private String image;

    private String taxType;
}
