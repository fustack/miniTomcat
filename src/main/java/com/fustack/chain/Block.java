package com.fustack.chain;

/**
 * Created by yaoagcn on 2019/12/13.
 */
public class Block<T> {

    private int index;

    private String previousHash;

    private String hash;

    private long timeStamp;

    private T data;


}
