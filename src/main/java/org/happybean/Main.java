package org.happybean;

import org.happybean.spring.aop.Aop;
import org.happybean.spring.aop.AopImpl;
import org.happybean.spring.ioc.Autowire;
import org.happybean.spring.ioc.AutowireImpl;
import org.happybean.spring.ioc.IocRegister;
import org.happybean.spring.ioc.IocRegisterImpl;
import org.happybean.spring.lifeCycle.LifeCycle;
import org.happybean.spring.lifeCycle.LifeCycleImpl;
import org.happybean.spring.profile.Profiles;
import org.happybean.spring.profile.ProfilesImpl;
import org.happybean.spring.transaction.DbTransaction;
import org.happybean.spring.transaction.DbTransactionImpl;
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
        //autowired();
        //profile();
        //aop();
        transaction();
    }

    //组件注册
    private static void ioc() {
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
    private static void lifeCyle() {
        LifeCycle lifeCycle = new LifeCycleImpl();
        //lifeCycle.xmlLifeCycle();
        //lifeCycle.beanLifeCycle();
        //lifeCycle.implementsInterface();
        //lifeCycle.JSR250();
        lifeCycle.beanPostProcessor();
    }

    //属性赋值
    private static void propertyValues() {
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

    //动态加载
    private static void profile() {
        Profiles profiles = new ProfilesImpl();
        profiles.profile();
    }

    //切面编程
    private static void aop() {
        Aop aop = new AopImpl();
        aop.apect();
    }

    //事务管理
    private static void transaction() {
        DbTransaction transaction = new DbTransactionImpl();
        transaction.transaction();
    }
}
