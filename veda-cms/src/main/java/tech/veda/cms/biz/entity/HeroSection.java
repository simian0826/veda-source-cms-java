package tech.veda.cms.biz.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import jakarta.validation.constraints.NotNull;
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
@TableName("t_hero_section")
public class HeroSection extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String background;
    @NotNull
    private String header;
    @NotNull
    private String content;
    @NotNull
    private String module;
}
