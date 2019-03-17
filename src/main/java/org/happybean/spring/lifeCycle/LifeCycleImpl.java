package org.happybean.spring.lifeCycle;

import org.happybean.spring.config.SpringLifeCycleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wgt
 * @date 2019-03-17
 * @description 对象创建完成，并对属赋值好，会调用初始化函数
 * 单实例：容器关闭时调用销毁方法
 * 多实例：容器不会自动调用销毁方法
 **/
public class LifeCycleImpl implements LifeCycle {

    @Override
    public void xmlLifeCycle() {
        //加载配置文件 初始化容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        //关闭容器
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Override
    public void beanLifeCycle() {
        //加载配置类 初始化容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringLifeCycleConfig.class);


        Object person = applicationContext.getBean("person");
        //关闭容器
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

    @Override
    public void implementsInterface() {
        //加载配置类 初始化容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringLifeCycleConfig.class);
        //关闭容器
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

    @Override
    public void JSR250() {
        //加载配置类 初始化容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringLifeCycleConfig.class);
        //关闭容器
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

    @Override
    public void beanPostProcessor() {
        //加载配置类 初始化容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringLifeCycleConfig.class);
        //关闭容器
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
