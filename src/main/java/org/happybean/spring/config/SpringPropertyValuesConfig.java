package org.happybean.spring.config;

import org.happybean.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wgt
 * @date 2019-03-18
 * @description 属性赋值
 **/
@Configuration
@PropertySource(value = {"classpath:spring-bean-values.properties"})
public class SpringPropertyValuesConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
