package com.ssm.pratice.demo.AbstractFactoryDemo;

/**
 * 产品2
 *
 * @author laosa
 * @date 2019/9/22 15:04
 */
public class Product2 implements IProduct {

    private String name;

    public Product2(String name) {
        this.name = name;
    }

    private Product2() {

    }

    @Override
    public String getProductName() {
        return this.name;
    }
}
