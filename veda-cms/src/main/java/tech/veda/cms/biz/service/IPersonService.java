package tech.veda.cms.biz.service;

import tech.veda.cms.biz.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;
import tech.veda.cms.biz.service.dto.PersonCreateDTO;
import tech.veda.cms.biz.service.dto.PersonUpdateDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bruno
 * @since 2024-07-04
 */
public interface IPersonService extends IService<Person> {

  Boolean createPerson(PersonCreateDTO personDTO);

  Boolean updatePerson(PersonUpdateDTO personDTO);

  Person findPerson(Integer id);
}
