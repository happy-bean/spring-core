package org.happybean.spring.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
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
@WebServlet(value = "/hello", asyncSupported = true)
public class SimpleServlet extends HttpServlet {
    //asyncSupported = true 表示支持异步模式
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //@WebServlet 使用注解方式实现路由
        //xml配置方式这里不做讲解

        //开启异步模式
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> {
            asyncContext.complete();
            //获取异步上下文
            AsyncContext asyncContext1 = req.getAsyncContext();
            //获取响应
            ServletResponse response = asyncContext1.getResponse();
            try {
                response.getWriter().write("hello");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
