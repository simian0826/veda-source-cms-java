package tech.veda.cms.biz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import tech.veda.cms.biz.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author Bruno
 * @since 2024-07-04
 */
@Getter
@Setter
@TableName("t_leader")
public class Leader extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private String image;
}
