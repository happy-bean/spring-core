package org.happybean.spring.config;

import org.happybean.bean.Animal;
import org.happybean.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author wgt
 * @date 2019-03-16
 * @description bean生命周期
 * 创建->初始化->销毁
 * spring容器管理bean的生命周期
 **/
public class SpringLifeCycleConfig {

    //自定义初始化销毁方法

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Person person() {

        return new Person("spring1", 20);
    }

    @Bean
    public Animal animal() {
        return new Animal();
    }
}
