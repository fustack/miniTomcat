package com.fustack.mini.startup;

import com.fustack.mini.connector.HttpConnector;

/**
 * Created by yaoagcn on 2019/6/17.
 */
public class Bootstrap {

    public static void main(String[] args) {
        new HttpConnector().start();
    }
}
