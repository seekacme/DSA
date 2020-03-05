package com.wgz.circle;

import com.wgz.AbstractList;

public class SingleCircleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

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

        if(index == 0){
            Node<E> newFirst = new Node<E>(element, first);

            //获取最后一个节点
            Node<E> last = this.size == 0 ? newFirst : node(this.size - 1);
            last.next = newFirst;
            first = newFirst;
        }else{
            Node<E> prev = node(index-1);
            prev.next = new Node<E>(element, prev.next);
        }

        size++;
    }

    public E remove(int index) {
        rangeCheck(index);
        Node<E> old = first;
        if(index == 0){
            if(this.size == 1){
                first = null;
            }else{
                Node<E> last = node(this.size - 1);
                first = first.next;
                last.next = first;
            }
        }else{
            Node prev = node(index-1);
            old = prev.next;
            prev.next = old.next;
        }

        this.size--;

        return old.element;
    }

    public int indexOf(E element) {

        Node node = first;
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

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(this.size).append(", [");
        Node node = first;
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node);

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

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append(element).append("_");
            str.append(next != null ? next.element : "null");

            return str.toString();
        }
    }

}
