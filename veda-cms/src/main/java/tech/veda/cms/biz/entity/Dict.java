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
 * @since 2024-06-22
 */
@Getter
@Setter
@TableName("t_dict")
public class Dict extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String label;

    private String value;

    private String type;
}
