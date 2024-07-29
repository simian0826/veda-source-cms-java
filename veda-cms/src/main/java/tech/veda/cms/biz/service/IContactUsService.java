package tech.veda.cms.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.veda.cms.biz.entity.ContactUs;
import tech.veda.cms.biz.service.dto.ContactUsDTO;

public interface IContactUsService extends IService<ContactUs> {


  Boolean sendMail(ContactUsDTO contactUsDTO);

}
