package com.ssm.pratice.demo.AbstractFactoryDemo;

/**
 * @author laosa
 * @date 2019/9/22 14:55
 */
public class ProductFactory2 implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        return new Product2("HUAWEI mate30 PRO");
    }
}
