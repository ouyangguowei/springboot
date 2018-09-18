package com.ouyoung.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ouyoung
 * @Date: 2018/9/19
 */
@RestController
public class TestController {

    @RequestMapping("/test/{params}")
    public Object test(@PathVariable String params){
        return "hello, params is " + params;
    }
}
