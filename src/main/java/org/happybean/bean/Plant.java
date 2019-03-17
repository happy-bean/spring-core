package org.happybean.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wgt
 * @date 2019-03-17
 * @description
 **/
public class Plant {

    public Plant() {
        System.out.println("构造器");
    }

    @PostConstruct
    public void init() {
        //@PostConstruct bean创建完成 属性赋值完成时调用该注解的方法
        System.out.println("bean 创建完成之后调用");
    }

    @PreDestroy
    public void destroy() {
        //@PreDestroy ean销毁之前调用该方法
        System.out.println("bean销毁之前调用");
    }
}
