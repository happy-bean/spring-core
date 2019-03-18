package org.happybean;

import org.happybean.spring.ioc.Autowire;
import org.happybean.spring.ioc.AutowireImpl;
import org.happybean.spring.ioc.IocRegister;
import org.happybean.spring.ioc.IocRegisterImpl;
import org.happybean.spring.lifeCycle.LifeCycle;
import org.happybean.spring.lifeCycle.LifeCycleImpl;
import org.happybean.spring.value.PropertyValues;
import org.happybean.spring.value.PropertyValuesImpl;

/**
 * @author wgt
 * @date 2019-03-14
 * @description
 **/
public class Main {
    public static void main(String[] args) {
        //ioc();
        //lifeCyle();
        //propertyValues();
        autowired();
    }

    //组件注册
    public static void ioc() {
        IocRegister iocTest = new IocRegisterImpl();
        //iocTest.xmlConfig();
        //iocTest.annotationConfig();
        //iocTest.xmlScan();
        //iocTest.annotationScan();
        //iocTest.condition();
        //iocTest.manual();
        //iocTest.imports();
        //iocTest.importSelector();
        iocTest.importBeanDefinitionRegistrar();
    }

    //生命周期
    public static void lifeCyle() {
        LifeCycle lifeCycle = new LifeCycleImpl();
        //lifeCycle.xmlLifeCycle();
        //lifeCycle.beanLifeCycle();
        //lifeCycle.implementsInterface();
        //lifeCycle.JSR250();
        lifeCycle.beanPostProcessor();
    }

    //属性赋值
    public static void propertyValues() {
        PropertyValues propertyValues = new PropertyValuesImpl();
        propertyValues.annotationConfig();
    }

    //自动装配
    private static void autowired() {
        Autowire autowire = new AutowireImpl();
        //autowire.autowired();
        autowire.jsr250();
        //autowire.jsr330();
    }
}
