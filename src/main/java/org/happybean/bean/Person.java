package org.happybean.bean;

/**
 * @author wgt
 * @date 2019-03-14
 * @description 测试类
 **/
public class Person {

    private String name;

    private int age;

    public Person() {
        System.out.println("创建Person对象");
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
