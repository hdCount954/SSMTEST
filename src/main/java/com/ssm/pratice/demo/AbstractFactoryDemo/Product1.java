package com.ssm.pratice.demo.AbstractFactoryDemo;

/**
 * 产品1
 *
 * @author laosa
 * @date 2019/9/22 15:04
 */
public class Product1 implements IProduct {

    private String name;

    public Product1(String name) {
        this.name = name;
    }

    private Product1() {

    }

    @Override
    public String getProductName() {
        return this.name;
    }
}
