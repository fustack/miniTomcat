package com.fustack.base.dataStructure.stack;

import com.fustack.base.dataStructure.list.KList;

/**
 * Created by yaoagcn on 2019/12/28.
 */
public class KStack<T> extends KList<T> {

    public KStack() {
        super();
    }

    public KStack(T data) {
        super(data);
    }

    public KStack push(final T data) {
        add(data);
        return this;
    }

    public T pop() {
        T popData = getLast();
        remove(popData);
        return popData;
    }

}
