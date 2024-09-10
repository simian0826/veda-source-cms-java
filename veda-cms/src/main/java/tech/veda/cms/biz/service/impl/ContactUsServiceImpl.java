package tech.veda.cms.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.veda.cms.biz.entity.ContactUs;
import tech.veda.cms.biz.entity.Product;
import tech.veda.cms.biz.entity.Project;
import tech.veda.cms.biz.exception.ProjectException;
import tech.veda.cms.biz.mapper.ContactUsMapper;
import tech.veda.cms.biz.service.IContactUsService;
import tech.veda.cms.biz.service.dto.ContactUsDTO;
import tech.veda.cms.biz.service.dto.ContactUsListRequestDTO;
import tech.veda.cms.biz.util.EmailUtil;
import tech.veda.cms.common.CommonResultStatus;
import tech.veda.cms.sys.service.dto.PageDTO;

import java.util.List;
import java.util.Objects;

/**
 * @author lizhiying
 */
@Service
public class ContactUsServiceImpl extends ServiceImpl<ContactUsMapper, ContactUs> implements IContactUsService {

  @Autowired
  EmailUtil emailUtil;

  @Override
  public Boolean sendMail(ContactUsDTO contactUsDTO) {

  if( emailUtil.sendEmail(contactUsDTO)){
    ContactUs contactUs = new ContactUs();
    contactUs.setEmail(contactUsDTO.getEmail());
    contactUs.setSubject(contactUsDTO.getSubject());
    contactUs.setMessage(contactUsDTO.getMessage());
    contactUs.setName(contactUsDTO.getName());

    this.save(contactUs);
  }

    return true;
  }

  @Override
  public PageDTO<ContactUs> getContactList(ContactUsListRequestDTO requestDTO) {

    Page<ContactUs> page = new Page<>(requestDTO.getPage(), requestDTO.getPageSize());

    QueryWrapper<ContactUs> queryContactUsWrapper = new QueryWrapper<>();
    if (!requestDTO.getName().isEmpty()){
      queryContactUsWrapper.eq("name",requestDTO.getName());
    }
    if (!requestDTO.getEmail().isEmpty()){
      queryContactUsWrapper.eq("email",requestDTO.getEmail());
    }
    if (!requestDTO.getSubject().isEmpty()){
      queryContactUsWrapper.eq("subject",requestDTO.getSubject());
    }
    IPage<ContactUs> contactUsPage = getBaseMapper().selectPage(page, queryContactUsWrapper);

    List<ContactUs> contactUsList = this.list(contactUsPage, queryContactUsWrapper);


    System.out.println("requestDTO:"+ requestDTO);
    return new PageDTO<>(contactUsList,this.count(queryContactUsWrapper));
  }

  @Override
  public Boolean deleteContactUs(Integer id) {

    ContactUs oldContact = this.getById(id);

    if(Objects.isNull(oldContact)){
      throw new ProjectException(CommonResultStatus.SERVER_ERROR, "This Contact data is not found which needs to delete");
    }

    return this.removeById(id);
  }
}
