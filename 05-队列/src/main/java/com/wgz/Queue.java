package com.wgz;

import com.wgz.list.LinkedList;
import com.wgz.list.List;

public class Queue<E> {

    private List<E> list = new LinkedList<E>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    /**
     * 从队尾入队
     * @param element
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 从队头出队
     * @return
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * 查看队头元素
     * @return
     */
    public E front() {
        return list.get(0);
    }
}
