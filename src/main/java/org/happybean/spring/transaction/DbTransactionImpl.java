package org.happybean.spring.transaction;

import org.happybean.service.UserService;
import org.happybean.spring.config.SpringProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wgt
 * @date 2019-03-20
 * @description
 **/
public class DbTransactionImpl implements DbTransaction {

    @Override
    public void transaction() {
        //加载配置类 此时的配置类等同于xml配置文件
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //设置好激活的环境 支持多个环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //注册配置
        applicationContext.register(SpringProfileConfig.class);
        applicationContext.refresh();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        UserService userService = applicationContext.getBean(UserService.class);
        userService.insert();

        applicationContext.close();
    }
}
