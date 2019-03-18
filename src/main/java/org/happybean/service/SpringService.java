package org.happybean.service;

import org.happybean.repository.SpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wgt
 * @date 2019-03-14
 * @description
 **/
@Service
public class SpringService {

    //@Resource java 规范，默认按属性名作为bean name装配
    //或使用 @Resource(name = "springRepository2") 指定bean name装配
    //不支持@Primary 优先装配和@Autowired(required = false)功能
    @Resource
    private SpringRepository springRepository;

    @Resource(name = "springRepository2")
    private SpringRepository springRepository2;

    private SpringRepository springRepository3;

    private SpringRepository springRepository4;

    private SpringRepository springRepository5;

    public SpringService() {
        System.out.println("无参构造器");
    }

    //spring默认注册组件时，会调用当前bean的无参构造器，
    //@Autowired 注解后，会调用该构造器，装配时参数名默认为 bean name
    //如果该类只有一个有参构造器，那么会和使用@Autowired一样
    @Autowired
    public SpringService(SpringRepository springRepository2) {
        this.springRepository4 = springRepository2;
        System.out.println("有参构造器");
    }

    public void printRepository() {
        System.out.println(this.springRepository);
        System.out.println(this.springRepository2);
        System.out.println(this.springRepository3);
        System.out.println(this.springRepository4);
        System.out.println(this.springRepository5);
    }

    public SpringRepository getSpringRepository3() {
        return springRepository3;
    }

    //@Autowired可以标注到方法上,spring创建当前对象时会调用该方法，参数名默认为 bean name
    @Autowired
    public void setSpringRepository3(SpringRepository springRepository) {
        this.springRepository3 = springRepository;
    }

    public SpringRepository getSpringRepository5() {
        return springRepository5;
    }

    public void setSpringRepository5(SpringRepository springRepository5) {
        this.springRepository5 = springRepository5;
    }
}
