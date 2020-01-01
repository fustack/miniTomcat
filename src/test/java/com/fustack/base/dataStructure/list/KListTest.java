package com.fustack.base.dataStructure.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yaoagcn on 2019/12/28.
 */
public class KListTest {

   private KList newKList() {
        return new KList<>(Arrays.asList("abc", "def", "ghi", "ded"));
   }

    @Test
    public void createKList() {
        Assert.assertNotNull(new KList<>());
        Assert.assertNotNull(new KList<>("abcd"));
        Assert.assertNotNull(new KList<>(Arrays.asList("abcd", "derr", "ererr")));
    }

    @Test
    public void testFind() {
        KList<String> kl = newKList();
        System.out.println(kl);
        kl.remove("abc");
        System.out.println(kl);
        kl.remove("ghi");
        System.out.println(kl);
        kl.remove("ded");
        System.out.println(kl);
    }


}
