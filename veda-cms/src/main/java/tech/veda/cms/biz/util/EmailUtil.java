package tech.veda.cms.biz.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tech.veda.cms.biz.service.dto.ContactUsDTO;

import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
/**
 * @author lizhiying
 */
@Component
public class EmailUtil {

  // Recipient email address
  @Value("${email.to}")
  private String to ;

  // Sender email address
  @Value("${email.from}")
  private String from ;

  // SMTP server
  @Value("${email.host}")
  private String host ;

  @Value("${email.port}")
  private String port;

  @Value("${email.auth}")
  private String auth;

  @Value("${email.subject}")
  private String subject;

  // 获取系统属性

  @Autowired
  private TemplateEngine templateEngine;

  public Boolean sendEmail(ContactUsDTO contactUsDTO){

    Properties properties = System.getProperties();

    properties.setProperty("mail.smtp.host", host);
    properties.setProperty("mail.smtp.port", port);
    properties.setProperty("mail.smtp.auth", "true");
    properties.setProperty("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(from, auth);
      }
    });
    try {
        // 创建默认的 MimeMessage 对象
        MimeMessage message = new MimeMessage(session);

        // 设置 From: 头部头字段
        message.setFrom(new InternetAddress(from));

        // 设置 To: 头部头字段
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // 设置 Subject: 头部头字段
        message.setSubject(subject);

        // 设置消息体
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      Context context = new Context();
      context.setVariable("name", contactUsDTO.getName());
      context.setVariable("email", contactUsDTO.getEmail());
      context.setVariable("mobile", contactUsDTO.getMobile());
      context.setVariable("message", contactUsDTO.getMessage());
      String emailContent = templateEngine.process("emailTemplate", context);
      messageBodyPart.setContent(emailContent, "text/html;charset=UTF-8");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);
      message.setContent(multipart);
      // 发送消息
      Transport.send(message);
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }

    return true;
  }





}
