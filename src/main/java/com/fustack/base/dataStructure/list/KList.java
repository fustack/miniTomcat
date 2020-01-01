package com.fustack.base.dataStructure.list;

import java.util.List;

/**
 *
 * 实现单链表、循环链表、双向链表，支持增删操作
 *
 * 实现单链表反转
 *
 * 实现两个有序的链表合并为一个有序链表
 *
 * 实现求链表的中间结点
 *
 * Created by yaoagcn on 2019/12/28.
 */
public class KList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;


    public KList(){}

    public KList(T data) {
        this.head = this.tail = newNode(data, null, null);
        length++;
    }

    public KList(T[] eles) {
        if (eles == null || eles.length == 0) {
            return;
        }

        for (T ele : eles) {
            add(ele);
        }
    }

    public KList(List<T> list) {
        this((T[]) list.toArray());
    }

    public KList add(T data) {
        Node newNode = new Node(data, null, null);
        if (tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        if (head == null || tail == null) {
            head = tail = newNode;
        }
        length++;
        return this;
    }

    public KList addHead(T data) {
        Node newNode = new Node(data, null, null);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            head = tail = newNode;
        }
        length++;
        return this;
    }

    public KList remove(T data) {
        Node node = find(data);
        if (node == null) {
            return this;
        }
        length--;
        if (node == head) {
            this.head = node.next;
            this.head.prev = null;
            return this;
        }
        if (node == tail) {
            this.tail = node.prev;
            this.tail.next = null;
            return this;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return this;
    }

    private boolean isContain(final T data) {
        return (find(data) != null);
    }

    private Node find(T data) {
        if (data == null) {
            // throw new NullPointerException(" can not find a null value.");
            return null;
        }
        Node tempNode = this.head;
        while (tempNode != null) {
            if (data == tempNode.value || data.equals(tempNode.value)) {
                return tempNode;
            } else if (data instanceof Comparable) {
                if(((Comparable)data).compareTo(tempNode.value) == 0) {
                    return tempNode;
                }
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    public T getLast() {
        return tail == null ? null : tail.value;
    }

    public T getHead() {
        return head == null ? null : head.value;
    }

    private Node<T> newNode(T value, Node next, Node prev) {
        return new Node(value, next, prev);
    }


    public void prtStr() {
        Node tempNode = this.head;
        int i = 0;
        while (tempNode.next != null) {
            if (i % 3 == 0) {
                System.out.println("\n");
            }
            System.out.println(tempNode.value.toString() + "    ");
            tempNode = tempNode.next;
        }
    }

    private static class Node<T> {
        T value;
        Node next;
        Node prev;

        Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
}
