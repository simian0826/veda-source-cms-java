package tech.veda.cms.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.service.IContactUsService;
import tech.veda.cms.biz.service.dto.ContactUsDTO;

/**
 * @author lizhiying
 */
@RestController
@RequestMapping("/contactUs/")
public class ContactUsController {


  @Autowired
  IContactUsService contactUsService;

  @PostMapping("/sendMail")
  public Result<Boolean> sendMail(@RequestBody ContactUsDTO contactUsDTO) {
    return Result.succ(contactUsService.sendMail(contactUsDTO));
  }

}
