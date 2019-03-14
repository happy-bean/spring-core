package org.happybean.spring.ioc;


/**
 * @author wgt
 * @date 2019-03-14
 * @description ioc组件注册
 **/
public interface Ioc {

    //组件注册：配置文件方式
    void xmlConfig();

    //组件注册：配置类方式
    void annotationConfig();
}
