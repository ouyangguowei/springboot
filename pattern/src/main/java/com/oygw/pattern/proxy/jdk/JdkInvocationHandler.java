package com.oygw.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: ouyoung
 * @Date: 2018/9/3
 */
public class JdkInvocationHandler implements InvocationHandler {

    private Object target;

    public JdkInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---JdkInvocationHandler invoke before ---------");
        Object ret = method.invoke(this.target,args);
        System.out.println("---JdkInvocationHandler invoke after ---------");
        return ret;
    }
}
