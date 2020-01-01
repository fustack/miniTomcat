package com.fustack.util;

import java.io.*;

/**
 * Created by yaoagcn on 2019/8/9.
 */
public class RWObjectUtil {

    public static void writeObject(Object o) {
        File file = new File("test.txt");
        FileOutputStream out;

        try {
            out = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(o);
            oos.flush();
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject() {
        Object temp = null;
        File file = new File("test.txt");
        FileInputStream in;

        try {
            in = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(in);
            temp = ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public static void main(String[] args) {
        TestBean t = new TestBean();
        t.setId(123);
        t.setName("abc");
        RWObjectUtil.writeObject(t);
        TestBean t1 = (TestBean) RWObjectUtil.readObject();
    }
}
