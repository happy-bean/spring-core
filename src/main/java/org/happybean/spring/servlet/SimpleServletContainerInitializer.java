package org.happybean.spring.servlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author wgt
 * @date 2019-04-03
 * @description
 **/
//@HandlesTypes 容器启动时，@HandlesTypes 指定的类的实现类 子类传递过来
@HandlesTypes(value = {PHttpServlet.class})
public class SimpleServletContainerInitializer implements ServletContainerInitializer {

    //1.Servlet容器启动会扫描当前应用所有jar中 ServletContainerInitializer的实现
    //也就是扫描META-INF/services/javax.servlet.ServletContainerInitializer中指定的实现类
    //2.提供ServletContainerInitializer的实现类
    //必须绑定在META_INF/services/javax.servlet.ServletContainerInitializer文件下
    //javax.servlet.ServletContainerInitializer 文件的内容就是ServletContainerInitializer实现类的全类名

    //应用启动时会触发该方法
    //servletContext代表当前web应用的ServletContext，1个web应用对应1个ServletContext对象
    //set 是@HandlesTypes传递过来类的class
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("===>>>");
        for (Class clazz : set) {
            System.out.println(clazz);
        }
    }
}
