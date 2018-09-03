package com.oygw.pattern.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: ouyoung
 * @Date: 2018/9/2
 */
public class CglibMethodInterceptor implements MethodInterceptor {

    private Object target;

    public CglibMethodInterceptor(Object target){
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---CglibMethodInterceptor intercept before ---------");
        Object ret = method.invoke(this.target,objects);
        System.out.println("---CglibMethodInterceptor intercept after ---------");
        return ret;
    }

}
