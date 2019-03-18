package org.happybean.service;

import org.happybean.repository.SpringRepository;
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

    public void printRepository() {
        System.out.println(this.springRepository);
        System.out.println(this.springRepository2);
    }
}
