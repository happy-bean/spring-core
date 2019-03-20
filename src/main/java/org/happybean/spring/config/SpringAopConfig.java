package org.happybean.spring.config;

import org.happybean.service.Calculator;
import org.happybean.service.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wgt
 * @date 2019-03-19
 * @description
 **/
@Configuration
@EnableAspectJAutoProxy
public class SpringAopConfig {
    //@EnableAspectJAutoProxy告诉spring启动切面自动代理
    //@EnableXXX 一般都是为了开启某种功能

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public LogAspect logApect() {
        return new LogAspect();
    }
}
