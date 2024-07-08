package tech.veda.cms.biz.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lizhiying
 */
@Aspect
@Component
public class MybatisPlusDataBaseAspect {

  // Define aspect point
  @Pointcut("execution(* com.baomidou.mybatisplus.extension.service.*.list*(..))")
  public void serviceLayerMethods() {
    System.out.println("Pointcut");

  }

  @Before("serviceLayerMethods()")
  public void beforeAdvice() {
    System.out.println("Before method execution");
  }

}
