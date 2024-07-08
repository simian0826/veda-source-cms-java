package tech.vedaSource.cms.biz.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import tech.vedaSource.cms.biz.common.BaseEntity;
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
@TableName("t_product")
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String category;

    private String description;

    private String imgs;

    private String certificate;

}
