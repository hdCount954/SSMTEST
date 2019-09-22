package com.ssm.pratice.demo.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 被观察对象-产品列表
 *
 * @author Laosa
 */
public class ProductList extends Observable {

    /**
     * 产品列表
     */
    private List<String> productList = null;

    /**
     * 类唯一实例
     */
    private static ProductList instance;

    /**
     * 构建方法私有化
     */
    private ProductList() {
    }

    /**
     * 取得唯一实例
     *
     * @return 产品列表唯一实例
     */
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }

    /**
     * 增加观察者（电商接口）
     *
     * @param observer 观察者
     */
    void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    public void addProduct(String newProduct) {

        productList.add(newProduct);
        System.err.println("产品列表新增了产品：" + newProduct);
        // 设置产品列表发生了变化状态
        this.setChanged();
        //通知观察者，并传递新产品
        this.notifyObservers(newProduct);
    }
}
