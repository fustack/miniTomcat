package com.fustack.util;

/**
 * Created by yaoagcn on 2019/12/17.
 */
public final class StrUitl {

    public static boolean isBlank(final String s) {
        if (s == null || s.trim().equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank(final String s) {
        return !isBlank(s);
    }
}
