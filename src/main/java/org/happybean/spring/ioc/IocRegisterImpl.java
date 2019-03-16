package org.happybean.spring.ioc;

import org.happybean.bean.Person;
import org.happybean.spring.config.SpringConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wgt
 * @date 2019-03-14
 * @description ioc组件注册
 **/
public class IocRegisterImpl implements IocRegister {

    @Override
    public void xmlConfig() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");

        //根据 bean name 获取，需要类型强制转换
        Person person1 = (Person) applicationContext.getBean("person1");
        System.out.println("person1:" + person1);

        //根据bean id 获取，需要类型强制转换
        Person person2 = (Person) applicationContext.getBean("person2-id");
        System.out.println("person2:" + person2);

        //根据bean类型获取，无需要类型强制转换，
        //使用此种方式时要保证改类型bean只配置一个，否则会抛出异常 org.springframework.beans.factory.NoUniqueBeanDefinitionException
        Person person3 = applicationContext.getBean(Person.class);
        System.out.println("person3:" + person3);

        //根据bean name和类型获取，无需要类型强制转换
        //多个相同类型bean时，可以使用该方法获取
        Person person4 = applicationContext.getBean("person1", Person.class);
        System.out.println("person4:" + person4);

        //默认单例模式注册到容器
        Person person11 = (Person) applicationContext.getBean("person1");
        System.out.println("is single:" + (person1 == person11));

    }

    @Override
    public void annotationConfig() {
        //加载配置类 此时的配置类等同于xml配置文件
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        //根据bean 默认name（方法名） 获取，需要类型强制转换
        Person person1 = (Person) applicationContext.getBean("person1");
        System.out.println("person1:" + person1);

        //根据 bean name 获取，需要类型强制转换
        Person person2 = (Person) applicationContext.getBean("person2-name");
        System.out.println("person2:" + person2);

        //根据bean name和类型获取，无需要类型强制转换
        //多个相同类型bean时，可以使用该方法获取
        Person person4 = applicationContext.getBean("person1", Person.class);
        System.out.println("person4:" + person4);

        //获取bean 在容器中的 name
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }

        //默认单例模式注册到容器
        Person person11 = (Person) applicationContext.getBean("person1");
        System.out.println("is single:" + (person1 == person11));
    }

    @Override
    public void xmlScan() {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scan.xml");

        //获取bean 在容器中的 name
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }

    @Override
    public void annotationScan() {
        //加载配置类 此时的配置类等同于xml配置文件
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        //获取bean 在容器中的 name
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }

    @Override
    public void condition() {
        //加载配置类 此时的配置类等同于xml配置文件
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取bean 在容器中的 name
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }

    @Override
    public void manual() {
        //加载配置类 此时的配置类等同于xml配置文件
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //获取bean工厂
        ConfigurableApplicationContext configurableContext = (ConfigurableApplicationContext) applicationContext;
        BeanDefinitionRegistry registry = (DefaultListableBeanFactory) configurableContext.getBeanFactory();
        //bean builder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //手动注册bean
        registry.registerBeanDefinition("manual", beanDefinition);

        //获取bean 在容器中的 name
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }

    @Override
    public void imports() {
        //加载配置类 此时的配置类等同于xml配置文件
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取bean 在容器中的 name
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }

    @Override
    public void importSelector() {
        //加载配置类 此时的配置类等同于xml配置文件
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取bean 在容器中的 name
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }

    @Override
    public void importBeanDefinitionRegistrar() {
        //加载配置类 此时的配置类等同于xml配置文件
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取bean 在容器中的 name
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }
    }
}
