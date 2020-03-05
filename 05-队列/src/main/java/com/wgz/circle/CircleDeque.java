package com.wgz.circle;

/**
 * 循环双端队列
 * @param <E>
 */
public class CircleDeque<E> {

    private E[] elements;
    private int size;
    private int front;

    public static final int DEFAULT_CAPACITY = 10;

    public CircleDeque(){
        this.elements = (E[])new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elements[index(i)] = null;
        }
        this.size = this.front = 0;
    }

    private int index(int index){
        index += this.front;
        if(index < 0){
            return index + this.elements.length;
        }
        return index - (index >= this.elements.length ? this.elements.length:0);
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

    /**
     * 尾部入队
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(this.size + 1);
        this.elements[index(this.size)] = element;
        this.size++;
    }

    /**
     * 头部出队
     * @return
     */
    public E deQueueFront() {
        E element = this.elements[this.front];
        this.elements[this.front] = null;
        this.front = index(1);
        this.size--;

        return element;
    }

    /**
     * 头部入队
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(this.size+1);

        this.front = index(-1);
        this.elements[this.front] = element;
        this.size++;
    }

    /**
     * 尾部出队
     * @return
     */
    public E deQueueRear() {
        int rearIndex = index(this.size-1);
        E element = this.elements[rearIndex];
        this.elements[rearIndex] = null;
        this.size--;
        return element;
    }

    /**
     * 获取头部元素
     * @return
     */
    public E front() {
        return this.elements[this.front];
    }

    /**
     * 获取尾部元素
     * @return
     */
    public E rear() {
        return this.elements[index(this.size -1)];
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
