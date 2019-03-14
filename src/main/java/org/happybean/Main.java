package org.happybean;

import org.happybean.spring.ioc.Ioc;
import org.happybean.spring.ioc.IocImpl;

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
        Ioc iocTest = new IocImpl();
        iocTest.xmlConfig();
        iocTest.annotationConfig();
    }
}
