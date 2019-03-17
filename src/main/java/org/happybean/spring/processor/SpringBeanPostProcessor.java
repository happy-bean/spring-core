package org.happybean.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author wgt
 * @date 2019-03-18
 * @description
 **/
public class SpringBeanPostProcessor implements BeanPostProcessor {

    //spring底层也大量使用BeanPostProcessor类
    //bean的赋值、 其它组件注入、@Autowired、生命周期的一些注解等
    /**
     * bea初始化之前调用
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization beanName:"+s+" "+o);
        return o;
    }

    /**
     * bean初始化之后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization beanName:"+s+" "+o);
        return o;
    }
}
