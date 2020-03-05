package com.wgz;

import com.wgz.list.LinkedList;
import com.wgz.list.List;

public class Deque<E> {

    private List<E> list = new LinkedList<E>();

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void clear() {
        this.list.clear();
    }

    /**
     * 尾部入队
     * @param element
     */
    public void enQueueRear(E element) {
        this.list.add(element);
    }

    /**
     * 头部出队
     * @return
     */
    public E deQueueFront() {
        return this.list.remove(0);
    }

    /**
     * 头部入队
     * @param element
     */
    public void enQueueFront(E element) {
        this.list.add(0, element);
    }

    /**
     * 尾部出队
     * @return
     */
    public E deQueueRear() {
        return this.list.remove(this.size() -1);
    }

    /**
     * 获取头部元素
     * @return
     */
    public E front() {
        return this.list.get(0);
    }

    /**
     * 获取尾部元素
     * @return
     */
    public E rear() {
        return this.list.get(this.size()-1);
    }

}
