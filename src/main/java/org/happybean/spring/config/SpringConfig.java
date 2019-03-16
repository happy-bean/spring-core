package org.happybean.spring.config;

import org.happybean.bean.Animal;
import org.happybean.bean.Person;
import org.happybean.condition.OsCondition;
import org.happybean.spring.importBeanDefinitionRegistrar.SpringImportBeanDefinitionRegistrar;
import org.happybean.spring.importSelector.SpringImportSelector;
import org.springframework.context.annotation.*;

/**
 * @author wgt
 * @date 2019-03-14
 * @description spring配置类 用于替换原来的 *.xml配置文件
 **/
@Configuration
@ComponentScan(value = {"org.happybean.controller", "org.happybean.service", "org.happybean.repository"})
//@Import({Animal.class})
//@Import(SpringImportSelector.class)
@Import(SpringImportBeanDefinitionRegistrar.class)
public class SpringConfig {

    //@Import 可以快速将某个类注册到容器，可以写多个class bean 默认name是类全名 例如：org.happybean.bean.Person


    //@Configuration 告诉spring这是一个配置类

    //@ComponentScan 替代了配置文件中的扫描标签
    //当然你也可以使用 @ComponentScan中的excludeFilters属性，排除不需要注册到容器中的类，或用includeFilters属性指定某个类注册到容器中

    @Bean
    @Scope("prototype")
    public Person person1() {
        //@Bean 将对象注册到容器 name默认为方法名
        //默认单例注册到容器，饿汉模式
        //@Scope("prototype")等同于配置文件

        return new Person("spring1", 20);
    }

    @Lazy
    @Bean(name = "person2-name")
    public Person person2() {
        //@Bean 将对象注册到容器 id默认为方法名
        //使用@Lazy将单例模式下的bean改为懒加载模式（懒汉模式）
        return new Person("spring2", 21);
    }

    @Bean
    @Conditional(OsCondition.class)
    public Person steveJobs() {
        //@Conditional 满足某种条件下才会注册bean
        return new Person("steveJobs", 56);
    }
}
