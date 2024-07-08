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
@TableName("t_general_config")
public class GeneralConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String data;

    private String type;
}
