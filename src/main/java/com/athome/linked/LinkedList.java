package com.athome.linked;

/**
 * @Author zhangxw03
 * @Dat 2020-12-15 12:55
 * @Describe 模拟LindedList实现增删改查
 */
public class LinkedList<E> {

    private volatile int size;

    private Node<E> head;

    private Node<E> tail;

    public LinkedList() {

    }

    public void add(E e) {
        //添加元素的关键点在于：1、取出尾节点l，因为添加一个新节点的前一个节点就是尾节点；
        // 2、将尾节点指向新创建的节点
        //3、判断新增加的这个节点是不是第一个节点，如果尾节点为null新增加的就是第一个节点，用head指向新创建的节点
        //4、如果新增加的节点不是第一个节点，那么尾节点的下一个元素就是新创建的节点
        //5、总结，new Node的时候，用尾节点构建了新创建节点的前一个节点，新节点的下一个节点始终为null;因为新创建
        //的节点始终是最后一个节点，因此用tail指向新创建的节点；再判断新创建的节点是不是第一个节点，如果是用head
        //指向，否则，就用尾节点的下一个节点指向新创建的节点

        final Node<E> l = tail;
        final Node newNode = new Node(l, null, e);
        tail = newNode;

        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private static class Node<E> {
        Node<E> pre;
        Node<E> next;
        E e;

        private Node(Node<E> pre, Node<E> next, E e) {
            this.pre = pre;
            this.next = next;
            this.e = e;
        }
    }
}
