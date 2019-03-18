package org.happybean.controller;

import org.happybean.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author wgt
 * @date 2019-03-14
 * @description
 **/
@Controller("SpringController")
public class SpringController {
    //默认以类首字母小写作为 bean name
    //或以@Controller("SpringController")方式自定义name

    //@Autowired 自动装配
    //默认先按类型去容器中获取相应的组件赋值
    //如果有多个相同类型bean实例，会以属性名找对应的bean组件
    //默认必须为属性装配，否则报错，或使用@Autowired(required = false) 如果找到bean则装配，否则不装配
    @Autowired
    private SpringService springService;

    @Autowired
    private SpringService springService2;

    //或在@Autowired注解基础上增加@Qualifier注解（括号内为bean组件name）来指定某个bean
    @Autowired
    @Qualifier("springService2")
    private SpringService springService3;

    @Autowired
    private SpringService springService4;

    public void printService() {
        System.out.println(this.springService);
        System.out.println(this.springService2);
        System.out.println(this.springService3);
        System.out.println(this.springService4);
    }

    public SpringService getSpringService() {
        return springService;
    }

    public void setSpringService(SpringService springService) {
        this.springService = springService;
    }

    public SpringService getSpringService2() {
        return springService2;
    }

    public void setSpringService2(SpringService springService2) {
        this.springService2 = springService2;
    }
}
