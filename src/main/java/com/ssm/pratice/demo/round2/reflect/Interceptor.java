package com.ssm.pratice.demo.round2.reflect;


import java.lang.reflect.Method;

/**
 * 自定义拦截器接口
 *
 * @author Laosa
 */
public interface Interceptor {

    public boolean before(Object proxy, Object target, Method method, Object args);

    public void around(Object proxy, Object target, Method method, Object args);

    public void after(Object proxy, Object target, Method method, Object args);
}
