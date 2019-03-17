package org.happybean.spring.lifeCycle;

/**
 * @author wgt
 * @date 2019-03-17
 * @description bean 生命周期
 * 创建->初始化->销毁
 * spring容器管理bean的生命周期
 **/
public interface LifeCycle {

    /**
     * 自定bean初始化销毁：xml配置文件方式
     */
    void xmlLifeCycle();

    /**
     * 自定bean初始化销毁：配置类方式
     */
    void beanLifeCycle();

    /**
     * 自定bean初始化销毁：通过实现spring提供的接口方式
     */
    void implementsInterface();

    /**
     * 自定bean初始化销毁：spring jsr-250注释
     * */
    void JSR250();
}
