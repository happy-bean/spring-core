package org.happybean.spring.config;

import org.happybean.repository.SpringRepository;
import org.happybean.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

    //AutowiredAnnotationBeanPostProcessor 类来完成自动装配

    //自定义组件如果想使用spring底层组件，如ApplicationContext，BeanFactory等
    //可以实现 XXXAware 来获取相应的组件 如ApplicationContextAware，在对象创建时，会调用相应实现方法，装配相应组件
    //XXXAware 都有对应的XXXProcessor进行处理 
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

    //@Autowired，装配时参数名默认为 bean name，也可以不写@Autowired
    @Bean
    public SpringService springService6(@Autowired SpringRepository springRepository2) {
        SpringService springService = new SpringService();
        springService.setSpringRepository5(springRepository2);
        return springService;
    }

    @Bean
    public SpringRepository springRepository2() {
        return new SpringRepository();
    }
}
