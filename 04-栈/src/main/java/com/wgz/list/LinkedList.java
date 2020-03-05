package com.wgz.list;

/**
 * 双向链表
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;

    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
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

        //往链表的最后添加元素
        if(index == this.size){
            Node<E> oldLast = last;
            last = new Node<E>(oldLast, element, null);
            if(oldLast == null){//这是链表添加的第一个元素
                first = last;
            }else{
                oldLast.next = last;
            }

        }else{
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<E>(prev, element, next);
            next.prev = node;

            //index==0
            if(prev == null){
                first = node;
            }else{
                prev.next = node;
            }
        }

        size++;
    }

    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if(prev == null){//删除首节点
            first = next;
        }else{
            prev.next = next;
        }

        if(index == this.size-1){//删除末尾节点
            last = prev;
        }else{
            next.prev = prev;
        }

        this.size--;

        return node.element;
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
        if(index < (this.size >> 1)){
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }else{
            node = last;
            for (int i = this.size-1; i > index; i--) {
                node = node.prev;
            }
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
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next){
            this.prev = prev;
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
            str.append(prev != null ? prev.element : "null");
            str.append("_").append(element).append("_");
            str.append(next != null ? next.element : "null");

            return str.toString();
        }
    }

}
