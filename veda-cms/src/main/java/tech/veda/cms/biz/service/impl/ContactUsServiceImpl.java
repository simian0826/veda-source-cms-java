package tech.veda.cms.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.veda.cms.biz.entity.ContactUs;
import tech.veda.cms.biz.entity.Dict;
import tech.veda.cms.biz.mapper.ContactUsMapper;
import tech.veda.cms.biz.mapper.DictMapper;
import tech.veda.cms.biz.service.IContactUsService;
import tech.veda.cms.biz.service.IDictService;
import tech.veda.cms.biz.service.dto.ContactUsDTO;
import tech.veda.cms.biz.util.EmailUtil;

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
    contactUs.setMobile(contactUsDTO.getMobile());
    contactUs.setMessage(contactUsDTO.getMessage());
    contactUs.setName(contactUsDTO.getName());

    this.save(contactUs);
  }

    return true;
  }
}
