package org.happybean.controller;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author wgt
 * @date 2019-04-09
 * @description
 **/
public class DeferredResultQueue {

    private static Queue<DeferredResult<String>> queue = new ConcurrentLinkedDeque<>();

    public static void add(DeferredResult<String> deferredResult){
        queue.add(deferredResult);
    }

    public static DeferredResult<String> get(){
        return queue.poll();
    }
}
