package org.happybean.spring.config;

import org.happybean.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wgt
 * @date 2019-03-14
 * @description spring配置类 用于替换原理的 *.xml配置文件
 **/
@Configuration
public class SpringConf {
    //@Configuration 告诉spring这是一个配置类

//    @Bean
//    public Person person(){
//        //@Bean 将对象注册到容器
//        return new Person("spring",20);
//    }
}
