package com.ssm.pratice.demo.AbstractFactoryDemo;

/**
 * 产品3
 *
 * @author laosa
 * @date 2019/9/22 15:04
 */
public class Product3 implements IProduct {

    private String name;

    public Product3(String name) {
        this.name = name;
    }

    private Product3() {

    }

    @Override
    public String getProductName() {
        return this.name;
    }
}
