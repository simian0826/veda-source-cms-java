package tech.veda.cms.biz.mapper;

import org.apache.ibatis.annotations.Mapper;
import tech.veda.cms.biz.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Bruno
 * @since 2024-07-04
 */

@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}
