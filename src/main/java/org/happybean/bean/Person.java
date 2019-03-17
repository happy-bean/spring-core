package org.happybean.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author wgt
 * @date 2019-03-14
 * @description 测试类
 **/
public class Person {

    //@Value()的值可以写
    //1.基本类型
    //2.spl表达式 #{}
    //3.${} 配置文件（或环境变量）

    @Value("@Value")
    private String name;

    @Value("#{12-2}")
    private int age;

    @Value("${person.sex}")
    private String sex;

    public Person() {
        System.out.println("创建Person对象");
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destory() {
        System.out.println("对象销毁");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        //单例模式时：默认容器加载时就会调用构造函数创建bean
        //多实例模式时：容器不会调用创建bean，在获取bean对象时才会创建
        System.out.println("创建Person对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
