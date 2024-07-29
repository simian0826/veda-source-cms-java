package tech.veda.cms;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lizhiying
 */

@EnableAspectJAutoProxy(exposeProxy = true)
@EnableConfigurationProperties(VedaSourceCMSProperties.class)
@MapperScan("tech.veda.cms.*.mapper")
@SpringBootApplication
public class VedaSourceCMSServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(VedaSourceCMSServerApplication.class, args);
  }

}
