package org.happybean.spring.aop;

import org.happybean.service.Calculator;
import org.happybean.spring.config.SpringAopConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wgt
 * @date 2019-03-19
 * @description
 **/
public class AopImpl implements Aop {
    @Override
    public void apect() {
        //加载配置类 初始化容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAopConfig.class);

        Calculator calculator = applicationContext.getBean(Calculator.class);
        calculator.div(2, 1);
        calculator.div(1, 0);
    }
}
