package com.wgz.circle;

import com.wgz.list.LinkedList;
import com.wgz.list.List;

/**
 * 循环队列
 * @param <E>
 */
public class CircleQueue<E> {

    private E[] elements;
    private int size;
    private int front;

    public static final int DEFAULT_CAPACITY = 10;

    public CircleQueue(){
        this.elements = (E[])new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elements[index(i)] = null;
        }
        this.size = this.front = 0;
    }

    /**
     * 从队尾入队
     * @param element
     */
    public void enQueue(E element) {
        ensureCapacity(this.size + 1);
        this.elements[index(this.size)] = element;
        this.size++;
    }

    /**
     * 确保有capacity的容量
     * @param capacity
     */
    public void ensureCapacity(int capacity){
        int oldCapacity = this.elements.length;
        if(oldCapacity >= capacity) return;
        //开始扩容
        int newCapacity = oldCapacity + (oldCapacity>>1);
        //按照新容量创建数组
        E[] newElements = (E[])new Object[newCapacity];
        //拷贝元素
        for (int i = 0; i < this.size; i++) {
            newElements[i] = this.elements[index(i)];
        }
        //替换指针
        this.elements = newElements;
        this.front = 0;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    private int index(int index){
        return (this.front + index) % this.elements.length;
    }

    /**
     * 从队头出队
     * @return
     */
    public E deQueue() {
        E element = this.elements[this.front];
        this.front = index(1);
        this.size--;

        return element;
    }

    /**
     * 查看队头元素
     * @return
     */
    public E front() {
        return this.elements[this.front];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity=").append(elements.length)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
