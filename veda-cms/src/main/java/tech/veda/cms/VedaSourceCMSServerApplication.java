package tech.veda.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lizhiying
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableConfigurationProperties(VedaSourceCMSProperties.class)
@SpringBootApplication
public class VedaSourceCMSServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(VedaSourceCMSServerApplication.class, args);
  }

}
