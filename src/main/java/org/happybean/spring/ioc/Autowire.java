package org.happybean.spring.ioc;

/**
 * @author wgt
 * @date 2019-03-18
 * @description 自动装配
 **/
public interface Autowire {

    /**
     * 自动装配：@Autowired方式
     */
    void autowired();

    /**
     * 自动装配：jsr250规范
     */
    void jsr250();

    /**
     * 自动装配：jsr330规范
     */
    void jsr330();
}
