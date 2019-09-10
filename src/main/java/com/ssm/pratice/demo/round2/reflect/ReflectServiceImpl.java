package com.ssm.pratice.demo.round2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {

    public static void main(String[] args) {
        ReflectServiceImpl reflectService = new ReflectServiceImpl("赵佳欢");
        reflectService.reflectTest();
    }

    private String name;

    public ReflectServiceImpl(String name) {
        System.out.println("构造方法：->" + name);
        this.name = name;
    }

    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    public void sayHello2() {
        System.out.println("hello " + name);
    }

    // 无参构造器
    public ReflectServiceImpl getInstance() {

        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.ssm.pratice.demo.round2.reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }


    public ReflectServiceImpl getInstance2() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)
                    Class.forName("com.ssm.pratice.demo.round2.reflect.ReflectServiceImpl")
                            .getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    //  反射对象+反射方法
    public Object reflectTest() {
        ReflectServiceImpl obj = null;
        try {
            obj = (ReflectServiceImpl) Class.forName("com.ssm.pratice.demo.round2.reflect.ReflectServiceImpl")
                    .getConstructor(String.class).newInstance("李四");

            Method method = obj.getClass().getMethod("sayHello", String.class);
            method.invoke(obj, "hhahhahahhahahhaah");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new Object();
    }
}
