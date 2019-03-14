package org.happybean;

import org.happybean.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wgt
 * @date 2019-03-14
 * @description
 **/
public class Main {
    public static void main(String[] args) {

    }

    public static void xml(){
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");

        //根据 bean name 获取，需要类型强制转换
        Person person1 = (Person) applicationContext.getBean("person1");
        System.out.println("person1:"+person1);

        //根据bean id 获取，需要类型强制转换
        Person person2 = (Person) applicationContext.getBean("person2-id");
        System.out.println("person2:"+person2);

        //根据bean类型获取，无需要类型强制转换，
        //使用此种方式时要保证改类型bean只配置一个，否则会抛出异常 org.springframework.beans.factory.NoUniqueBeanDefinitionException
        Person person3 = applicationContext.getBean(Person.class);
        System.out.println("person3:"+person3);

        //根据bean name和类型获取，无需要类型强制转换
        //多个相同类型bean时，可以使用该方法获取
        Person person4 = applicationContext.getBean("person1", Person.class);
        System.out.println("person4:"+person4);
    }
}
