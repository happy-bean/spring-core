package org.happybean.spring.value;

import org.happybean.spring.config.SpringPropertyValuesConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wgt
 * @date 2019-03-18
 * @description
 **/
public class PropertyValuesImpl implements PropertyValues {

    @Override
    public void annotationConfig() {
        //加载配置类 初始化容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringPropertyValuesConfig.class);
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");

        Object person = applicationContext.getBean("person");
        System.out.println(person);
    }
}
