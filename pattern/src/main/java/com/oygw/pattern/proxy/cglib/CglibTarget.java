package com.oygw.pattern.proxy.cglib;

/**
 * @Author: ouyoung
 * @Date: 2018/9/2
 */
public class CglibTarget {

    public String findLover(){
        System.out.println("CglibTarget invoke method");
        return "CglibTarget invoke method";
    }
}
