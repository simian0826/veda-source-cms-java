package tech.veda.cms.biz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import tech.vedaSource.cms.biz.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bruno
 * @since 2024-07-24
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

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
