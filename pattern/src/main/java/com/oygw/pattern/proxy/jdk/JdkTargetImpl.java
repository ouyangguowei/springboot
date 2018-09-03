package com.oygw.pattern.proxy.jdk;

/**
 * @Author: ouyoung
 * @Date: 2018/9/3
 */
public class JdkTargetImpl implements JdkTargetInterface {
    @Override
    public String findLover() {
        System.out.println("JdkTargetImpl invoke method");
        return "JdkTargetImpl invoke method";
    }
}
