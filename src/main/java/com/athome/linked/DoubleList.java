package com.athome.linked;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangxw03
 * @Dat 2020-12-15 8:59
 * @Describe 这个链表初始化的时候虚拟两个节点分别是head和tail
 */
public class DoubleList<E> {

    Node head;
    Node tail;

    public DoubleList() {
        Node nodeHead = new Node("head");
        Node nodeTail = new Node("tail");

        head = nodeHead;
        tail = nodeTail;

        head.next = tail;
        tail.pre = head;
    }

    public void add(E e) {
        //关键点在于取出尾节点的前一个节点，将这个节点的下一个节点指向新增加的节点，新增加节点的前一个节点指向这个节点；
        Node<E> node = new Node<>(e);

        //处理新增加节点的右边

        //尾节点的前一个节点的下一个节点指向新增加节点
        Node tailPre = tail.pre;
        tailPre.next = node;
        //新增加节点的前一个节点指向
        node.pre = tailPre;

        //然后处理新增加节点的左边
        tail.pre = node;
        node.next = tail;
    }

    public void remove(E e) {
        //删除的过程，1、找到要删除的node,取出这个node的前一个nodePre和这个node的后一个nodeNext
        //2、将node的pre置为null next置为null  等待垃圾回收器回收
        //3、将nodePre的next指向nodeNext，将nodeNext的pre指向nodePre 完成删除操作

        //List list = new LinkedList();
        for (Node<E> x = head; x != null; x = x.next) {
            if (x.e.equals(e)) {
                //删除该元素
                Node pre = x.pre;
                Node next = x.next;

                x.pre = null;
                x.next = null;

                pre.next = next;
                next.pre = pre;

            }
        }
    }

    private static class Node<E> {
        E e;
        Node pre;
        Node next;

        public Node(E e) {
            this.e = e;

            pre = null;
            next = null;
        }

    }

    public static void main(String[] args) {
        DoubleList<String> list = new DoubleList<>();

        list.add("1");

        for (Node<String> n = list.head; n != null; n = n.next) {
            System.out.println(n.e);
        }

        list.remove("1");

        for (Node<String> n = list.head; n != null; n = n.next) {
            System.out.println(n.e);
        }
    }
}
