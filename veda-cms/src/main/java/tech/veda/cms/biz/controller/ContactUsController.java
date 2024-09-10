package tech.veda.cms.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veda.cms.biz.common.Result;
import tech.veda.cms.biz.entity.ContactUs;
import tech.veda.cms.biz.service.IContactUsService;
import tech.veda.cms.biz.service.dto.ContactUsDTO;
import tech.veda.cms.biz.service.dto.ContactUsListRequestDTO;
import tech.veda.cms.biz.service.vo.ProductVO;
import tech.veda.cms.biz.service.vo.ProjectVO;
import tech.veda.cms.sys.service.dto.PageDTO;

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

  @GetMapping("/list")
  public Result<PageDTO<ContactUs>> getContactList(
    @RequestParam(defaultValue = "", required = false) String name,
    @RequestParam(defaultValue = "", required = false) String email,
    @RequestParam(defaultValue = "", required = false) String subject,
    @RequestParam Integer page,
    @RequestParam Integer pageSize
    ) {
    ContactUsListRequestDTO requestDTO = new ContactUsListRequestDTO();
    requestDTO.setEmail(email);
    requestDTO.setName(name);
    requestDTO.setSubject(subject);
    requestDTO.setPage(page);
    requestDTO.setPageSize(pageSize);
    return Result.succ(contactUsService.getContactList(requestDTO));

  }

  @PostMapping("/delete/{id}")
  public Result<ProjectVO> deleteContactUs(@PathVariable Integer id) {

    return Result.succ(contactUsService.deleteContactUs(id));
  }

}
