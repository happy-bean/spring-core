package org.happybean;

import org.happybean.spring.ioc.IocRegister;
import org.happybean.spring.ioc.IocRegisterImpl;

/**
 * @author wgt
 * @date 2019-03-14
 * @description
 **/
public class Main {
    public static void main(String[] args) {
        ioc();
    }

    //组件注册
    public static void ioc() {
        IocRegister iocTest = new IocRegisterImpl();
        //iocTest.xmlConfig();
        //iocTest.annotationConfig();
        //iocTest.xmlScan();
        iocTest.annotationScan();
    }
}
