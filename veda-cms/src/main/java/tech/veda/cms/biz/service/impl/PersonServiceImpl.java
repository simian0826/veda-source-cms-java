package tech.veda.cms.biz.service.impl;

import tech.veda.cms.biz.entity.Person;
import tech.veda.cms.biz.mapper.PersonMapper;
import tech.veda.cms.biz.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.veda.cms.biz.service.dto.PersonCreateDTO;
import tech.veda.cms.biz.service.dto.PersonUpdateDTO;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bruno
 * @since 2024-07-04
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

  @Override
  public Boolean createPerson(PersonCreateDTO personDTO) {

    Person person = new Person();
    person.setName(personDTO.getName());
    person.setDescription(personDTO.getDescription());
    person.setImage(personDTO.getImage());
    person.setCreateDate(LocalDateTime.now());
    return this.save(person);
  }

  @Override
  public Boolean updatePerson(PersonUpdateDTO personDTO) {

    Person person = new Person();
    person.setId(personDTO.getId());
    person.setName(personDTO.getName());
    person.setDescription(personDTO.getDescription());
    person.setImage(personDTO.getImage());
    person.setCreateDate(LocalDateTime.now());
    return this.saveOrUpdate(person);
  }

  @Override
  public Person findPerson(Integer id) {

    Optional<Person> optionalPerson = this.getOptById(id);
    if(optionalPerson.isPresent()){
      return  optionalPerson.get();
    }else {
      return null;
    }
  }


}
