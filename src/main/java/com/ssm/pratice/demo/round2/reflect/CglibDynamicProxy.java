package com.ssm.pratice.demo.round2.reflect;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 动态代理类
 *
 * @author Laosa
 */
public class CglibDynamicProxy implements MethodInterceptor {

    /**
     * 生成CGLIB代理对象
     *
     * @param cls -Class类
     * @return cls类的CGLIB代理对象
     */
    private Object getProxy(Class cls) {

        // CGLIB enhancer 增强类对象
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(cls);
        // 定义代理逻辑对象为当前对象，要求当前对象实现MethodIntercetor接口
        enhancer.setCallback(this);
        // 生成代理对象并返回
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args
            , MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真是对象前！");
        // CGLIB反射调用真是对象方法
        Object result = methodProxy.invokeSuper(proxy, args);
        System.out.println("调用真是对象之后！");

        return result;
    }

    /**
     * CGLIB测试方法
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();

        CglibUseClass useClass = (CglibUseClass) cglibDynamicProxy.getProxy(CglibUseClass.class);

        useClass.sayHelloWorld();

    }
}
