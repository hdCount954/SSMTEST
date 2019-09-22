package com.ssm.pratice.demo.AbstractFactoryDemo;

/**
 * @author laosa
 * @date 2019/9/22 15:12
 */
public class AbstractFactoryMainTest {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        IProduct product1 = productFactory.createProduct("1");
        IProduct product2 = productFactory.createProduct("2");
        IProduct product3 = productFactory.createProduct("3");
        IProduct product7 = productFactory.createProduct("7");
    }
}
