package com.ssm.pratice.demo.AbstractFactoryDemo;

/**
 * @author laosa
 * @date 2019/9/22 14:57
 */
public class ProductFactory implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        IProduct product = null;
        switch (productNo) {
            case "1":
                System.err.println("生成产品1，并返回！");
                product = new ProductFactory1().createProduct(productNo);
                break;
            case "2":
                System.err.println("生成产品2，并返回！");
                product = new ProductFactory2().createProduct(productNo);
                break;
            case "3":
                System.err.println("生成产品3，并返回！");
                product = new ProductFactory3().createProduct(productNo);
                ;
                break;
            default:
                System.err.println("产品NO错误，请校验！");
                break;
        }
        if (product != null) {
            System.err.println(product.getProductName());
        }

        return product;
    }
}
