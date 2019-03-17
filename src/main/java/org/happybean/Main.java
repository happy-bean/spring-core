package org.happybean;

import org.happybean.spring.ioc.IocRegister;
import org.happybean.spring.ioc.IocRegisterImpl;
import org.happybean.spring.lifeCycle.LifeCycle;
import org.happybean.spring.lifeCycle.LifeCycleImpl;

/**
 * @author wgt
 * @date 2019-03-14
 * @description
 **/
public class Main {
    public static void main(String[] args) {
        //ioc();
        lifeCyle();
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

    public static void lifeCyle(){
        LifeCycle lifeCycle = new LifeCycleImpl();
        //lifeCycle.xmlLifeCycle();
        //lifeCycle.beanLifeCycle();
        lifeCycle.implementsInterface();
    }
}
