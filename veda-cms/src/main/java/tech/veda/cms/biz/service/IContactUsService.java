package tech.veda.cms.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.veda.cms.biz.entity.ContactUs;
import tech.veda.cms.biz.service.dto.ContactUsDTO;
import tech.veda.cms.biz.service.dto.ContactUsListRequestDTO;
import tech.veda.cms.sys.service.dto.PageDTO;

public interface IContactUsService extends IService<ContactUs> {


  Boolean sendMail(ContactUsDTO contactUsDTO);

  PageDTO<ContactUs> getContactList(ContactUsListRequestDTO requestDTO);

  Boolean deleteContactUs(Integer id);
}
