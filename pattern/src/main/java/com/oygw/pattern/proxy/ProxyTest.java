package com.oygw.pattern.proxy;

import com.oygw.pattern.proxy.cglib.CglibMethodInterceptor;
import com.oygw.pattern.proxy.cglib.CglibTarget;
import com.oygw.pattern.proxy.jdk.JdkInvocationHandler;
import com.oygw.pattern.proxy.jdk.JdkTargetImpl;
import com.oygw.pattern.proxy.jdk.JdkTargetInterface;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @Author: ouyoung
 * @Date: 2018/9/2
 */
public class ProxyTest {

    public static void main(String[] args)  throws Exception{
        CglibTarget cglibTarget = new CglibTarget();
        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor(cglibTarget);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cglibTarget.getClass());
        enhancer.setCallback(cglibMethodInterceptor);
        CglibTarget cglibTargetProxy = (CglibTarget) enhancer.create();
        System.out.println(cglibTargetProxy.getClass());
        cglibTargetProxy.findLover();
        System.out.println("-------------------");

//        //目标对象
//        TargetObject target = new TargetObject();
//        //拦截器
//        MyInterceptor myInterceptor = new MyInterceptor(target);
//
//        /*
//         *  Proxy.newProxyInstance参数：
//         * 	1、目标类的类加载器
//         * 	2、目标类的所有的接口
//         *  3、拦截器
//         */
//        //代理对象，调用系统方法自动生成
//        TargetInterface proxyObj = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), myInterceptor);
//        proxyObj.business();
        //原理：
        //1、拿到被代理对象的引用，并且获取到它的所有的接口，反射获取
        //2、JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类所有实现的所有的接口
        //3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
        //4、编译新生成的Java代码.class
        //5、再重新加载到JVM中运行
        //以上这个过程就叫字节码重组

        //JDK中有个规范，只要要是$开头的一般都是自动生成的
        JdkTargetImpl jdkTargetImpl = new JdkTargetImpl();
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(jdkTargetImpl);
        JdkTargetInterface jdkTargert = (JdkTargetInterface) Proxy.newProxyInstance(jdkTargetImpl.getClass().getClassLoader(), jdkTargetImpl.getClass().getInterfaces(), jdkInvocationHandler);
        System.out.println(jdkTargert.getClass());
        jdkTargert.findLover();
    }
}
