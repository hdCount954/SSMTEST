package com.ssm.pratice.demo.AbstractFactoryDemo;

/**
 * 工厂接口
 *
 * @author laosa
 * @date 2019/9/22 14:49
 */
public interface IProductFactory {

    public IProduct createProduct(String productNo);
}
