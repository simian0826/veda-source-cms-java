package tech.veda.cms.infra;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * @author lizhiying
 */
@Configuration
public class ThymeleafConfig {

  @Bean
  public ClassLoaderTemplateResolver templateResolver() {
    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("/templates/"); // 前缀
    templateResolver.setSuffix(".html"); // 后缀
    templateResolver.setTemplateMode(TemplateMode.HTML); // 模板模式
    templateResolver.setCharacterEncoding("UTF-8"); // 字符编码
    templateResolver.setCacheable(false);
    return templateResolver;
  }

  @Bean
  @ConditionalOnMissingBean(TemplateEngine.class)
  public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);
    return templateEngine;
  }
}
