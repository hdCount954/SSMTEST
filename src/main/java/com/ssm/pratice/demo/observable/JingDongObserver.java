package com.ssm.pratice.demo.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 京东电商接口
 *
 * @author Laosa
 */
public class JingDongObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        String newProduct = (String) arg;
        // 添加京东自定义的发布新品逻辑
        System.err.println("自定义发布新产品【" + newProduct + "】到京东商城！");
    }
}
