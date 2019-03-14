package org.happybean.spring.config;

import org.happybean.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author wgt
 * @date 2019-03-14
 * @description spring配置类 用于替换原来的 *.xml配置文件
 **/
@Configuration
@ComponentScan(value = {"org.happybean.controller", "org.happybean.service", "org.happybean.repository"})
public class SpringConfig {

    //@Configuration 告诉spring这是一个配置类

    //@ComponentScan 替代了配置文件中的扫描标签
    //当然你也可以使用 @ComponentScan中的excludeFilters属性，排除不需要注册到容器中的类，或用includeFilters属性指定某个类注册到容器中

    @Bean
    @Scope("prototype")
    public Person person1() {
        //@Bean 将对象注册到容器 name默认为方法名
        //默认单例注册到容器
        //@Scope("prototype")等同于配置文件

        return new Person("spring1", 20);
    }

    @Bean(name = "person2-name")
    public Person person2() {
        //@Bean 将对象注册到容器 id默认为方法名
        return new Person("spring2", 21);
    }
}
