package com.fustack.base.dataStructure.array;

import java.util.List;

/**
 * 实现一个支持动态扩容的数组
 * 实现一个大小固定的有序数组，支持动态增删改操作
 *
 * 实现两个有序数组合并为一个有序数组
 *
 * Created by yaoagcn on 2019/12/28.
 */
public class KArray<T>{

    private int length;
    private Object[] values;

    public KArray() {}

    public KArray(int size) {
        if (size < 1 || size > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("invalid size: " + size);
        }
        values = new Object[size];
        length = size;
    }

    public KArray(KArray ka) {

    }
}
