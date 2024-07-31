package tech.veda.cms.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import tech.veda.cms.biz.entity.Person;
import tech.veda.cms.biz.entity.Product;
import tech.veda.cms.biz.mapper.PersonMapper;
import tech.veda.cms.biz.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.veda.cms.biz.service.dto.PageRequestDTO;
import tech.veda.cms.biz.service.dto.PersonCreateDTO;
import tech.veda.cms.biz.service.dto.PersonUpdateDTO;
import tech.veda.cms.sys.service.dto.PageDTO;

import java.time.LocalDateTime;
import java.util.List;
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

  @Override
  public PageDTO<Person> findPeople(PageRequestDTO pageRequestDTO) {

    Page<Person> page = new Page<>(pageRequestDTO.getPage(), pageRequestDTO.getPageSize());

    QueryWrapper<Person> queryPersonWrapper = new QueryWrapper<>();

    IPage<Person> personPage = getBaseMapper().selectPage(page, queryPersonWrapper);

    List<Person> people = this.list(personPage);
    return new PageDTO(people, this.count());
  }

  @Override
  public Boolean deletePerson(Integer id) {

    return this.removeById(id);
  }


}
