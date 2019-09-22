package com.ssm.pratice.demo.observable;

/**
 * 观察者模式测试main
 * @author Laosa
 */
public class MainTest {
    public static void main(String[] args) {
        // 获取被观察者【产品列表】
        ProductList observable = ProductList.getInstance();
        JingDongObserver jingDongObserver = new JingDongObserver();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        observable.addProductListObserver(jingDongObserver);
        observable.addProductListObserver(taoBaoObserver);
        observable.addProduct("华为mate30 Pro");
    }
}
