package org.happybean.spring.ioc;


/**
 * @author wgt
 * @date 2019-03-14
 * @description ioc组件注册
 **/
public interface IocRegister {

    //组件注册：配置文件方式
    void xmlConfig();

    //组件注册：配置类方式
    void annotationConfig();

    //组件注册：配置文件扫描方式
    void xmlScan();

    //组件注册：配置类扫描方式
    void annotationScan();

    //组件注册：条件注册方式
    void condition();

    //组件注册：手动注册
    void manual();
}
