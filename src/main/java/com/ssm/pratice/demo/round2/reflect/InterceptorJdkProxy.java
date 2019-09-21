package com.ssm.pratice.demo.round2.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 拦截器JDK代理
 *
 * @author Laosa
 */
public class InterceptorJdkProxy implements InvocationHandler {

    /**
     * 真实对象
     */
    private Object target;

    /**
     * 拦截器全限定名
     */
    private String interceptorClass;

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象，并返回一个【代理占位】
     *
     * @param target           真实对象
     * @param interceptorClass 真实对象全限定名
     * @return 代理对象【占位】
     */
    public static Object bind(Object target, String interceptorClass) {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }

    /**
     * 通过代理对象调用方法，首先进入这个方法
     *
     * @param proxy  代理对象
     * @param method 被调用的方法
     * @param args   方法参数
     * @return 方法返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            return method.invoke(target, args);
        }

        Object result = null;

        // 通过反射生成拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        // 调用前置自定义方法
        if (interceptor.before(proxy, target, method, args)) {
            result = method.invoke(target, args);
        } else {
            // 返回false执行around方法
            interceptor.around(proxy, target, method, args);
        }

        // 调用后置自定义方法
        interceptor.after(proxy, target, method, args);

        return result;
    }

    /**
     * 测试
     *
     * @param args 参数
     */
    public static void main(String[] args) {

        HelloWorld helloWorld = (HelloWorld) InterceptorJdkProxy
                .bind(new HelloworldImpl(), "com.ssm.pratice.demo.round2.reflect.MyInterceptor");
        helloWorld.sayHelloWorld();
        helloWorld.goodJob();

    }
}
