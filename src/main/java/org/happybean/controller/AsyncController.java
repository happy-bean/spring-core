package org.happybean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @author wgt
 * @date 2019-04-09
 * @description
 **/
@Controller
public class AsyncController {

    //1.springmvc方式异步处理返回Callable
    //2.spring异步处理，将Callable提交到TaskExecutor使用一个隔离的线程执行
    //3.DispatcherServlet和所有的Filter退出线程，response继续保留打开状态
    //4.Callable返回结果，springMcv将重新派发给容器，恢复之前处理
    //5.根据Callable返回的结果，渲染数据
    @ResponseBody
    @RequestMapping("/async1")
    public Callable<String> async1(){
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "async1";
            }
        };
        return callable;
    }

    @RequestMapping("/async2")
    public DeferredResult<String> async2(){
        DeferredResult<String> result = new DeferredResult<>(3000L,"failed");
        DeferredResultQueue.add(result);
        //以下可写在异步线程中执行
        DeferredResult<String> result1 = DeferredResultQueue.get();
        result1.setResult("success");

        return result;
    }
}
