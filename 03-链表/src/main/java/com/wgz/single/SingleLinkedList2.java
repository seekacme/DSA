package com.wgz.single;

import com.wgz.AbstractList;

/**
 * 有虚拟节点的单向链表
 * @param <E>
 */
public class SingleLinkedList2<E> extends AbstractList<E> {

    private Node<E> first;

    public SingleLinkedList2(){
        // 虚拟头结点
        first = new Node<E>(null, null);
    }

    public void clear() {
        this.size = 0;
        this.first = null;
    }

    public E get(int index) {
        return node(index).element;
    }

    public E set(int index, E element) {
        Node<E> oldNode = node(index);
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);

        Node<E> prev = index == 0 ? first : node(index-1);
        prev.next = new Node<E>(element, prev.next);

        size++;
    }

    public E remove(int index) {
        rangeCheck(index);
        Node<E> old = first;

        Node prev = index == 0 ? first : node(index-1);
        old = prev.next;
        prev.next = prev.next.next;

        this.size--;

        return old.element;
    }

    public int indexOf(E element) {

        Node node = first.next;
        if(element == null){
            for (int i = 0; i < this.size; i++) {
                if(node.element == null) return i;
                node = node.next;
            }
        }else{
            for (int i = 0; i < this.size; i++) {
                if(node.element.equals(element)) return i;
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点
     * @param index
     * @return
     */
    private Node<E> node(int index){
        rangeCheck(index);

        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(this.size).append(", [");
        Node node = first.next;
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node.element);

            node = node.next;

        }
        string.append("]");
        return string.toString();
    }

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Node finalize...");
        }
    }

}
