package org.happybean.spring.config;

import org.happybean.repository.SpringRepository;
import org.happybean.service.SpringService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author wgt
 * @date 2019-03-18
 * @description 自动装配
 **/
@Configuration
@ComponentScan(value = {"org.happybean.controller", "org.happybean.service", "org.happybean.repository"})
public class SpringAutowiredConfig {

    @Bean
    public SpringService springService2() {
        return new SpringService();
    }

    //用@Primary时 容器会优先使用该bean装配，忽略name规则
    @Primary
    @Bean
    public SpringService springService3() {
        return new SpringService();
    }

    @Bean
    public SpringRepository springRepository2() {
        return new SpringRepository();
    }
}
