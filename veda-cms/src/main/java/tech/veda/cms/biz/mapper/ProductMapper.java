package tech.veda.cms.biz.mapper;

import org.apache.ibatis.annotations.Mapper;
import tech.veda.cms.biz.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Bruno
 * @since 2024-06-22
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
