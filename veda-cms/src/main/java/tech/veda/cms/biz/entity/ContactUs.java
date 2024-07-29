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
 * @since 2024-07-25
 */
@Getter
@Setter
@TableName("t_contact_us")
public class ContactUs extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String mobile;

    private String message;
}
