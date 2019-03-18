package org.happybean.spring.profile;

import org.happybean.spring.config.SpringProfileConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author wgt
 * @date 2019-03-18
 * @description
 **/
public class ProfilesImpl implements Profiles {

    //指定某种环境
    //1.命令行参数：在虚拟机启动参数加上 -Dspring.profiles.active=test
    //2.applicationContext.getEnvironment().setActiveProfiles("dev", "pro");
    @Override
    public void profile() {
        //加载配置类 此时的配置类等同于xml配置文件
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //设置好激活的环境 支持多个环境
        applicationContext.getEnvironment().setActiveProfiles("dev", "pro");
        //注册配置
        applicationContext.register(SpringProfileConfig.class);
        applicationContext.refresh();

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        String[] beanNames = applicationContext.getBeanNamesForType(DataSource.class);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
