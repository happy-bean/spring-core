package org.happybean.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author wgt
 * @date 2019-03-15
 * @description 测试类
 **/
public class Animal implements InitializingBean, DisposableBean {

    public Animal() {
    }

    /**
     * 初始化方法
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("对象初始化");
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("对象销毁");
    }
}
