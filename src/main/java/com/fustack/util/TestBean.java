package com.fustack.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by yaoagcn on 2019/8/9.
 */
public class TestBean implements Serializable {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeByte(id);
        oos.writeBytes(name);
    }

    private void readObject(ObjectInputStream ois) throws IOException {
        id = ois.readInt();
        //name = ois.readUTF();
      //  name = String.valueOf(ois.readByte());
    }
}
