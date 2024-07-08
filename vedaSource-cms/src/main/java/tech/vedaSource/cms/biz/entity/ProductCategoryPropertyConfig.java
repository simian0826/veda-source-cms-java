package tech.vedaSource.cms.biz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import tech.vedaSource.cms.biz.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author Bruno
 * @since 2024-06-27
 */
@Getter
@Setter
@TableName("t_product_category_property_config")
public class ProductCategoryPropertyConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String category;

    private String propertyName;
}
