package org.happybean.spring.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wgt
 * @date 2019-04-03
 * @description
 **/
//@WebServlet("/hello")
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //@WebServlet 使用注解方式实现路由
        //xml配置方式这里不做讲解
        resp.getWriter().write("hello");
    }

}
