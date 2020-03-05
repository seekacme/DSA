package com.wgz;


/**
 * 动态数组（有缩容操作）
 */
public class ArrayList2<E> {

    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有的元素
     */
    private E[] elements;

    /**
     * 默认容量
     */
    public static final int DEFAULT_CAPACITY = 10;

    /**
     * 没有找到元素
     */
    public static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList2(int capacity){
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        this.elements = (E[]) new Object[capacity];
    }

    public ArrayList2(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear(){
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size==0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到最后面
     * @param element
     */
    public void add(E element){
        this.add(this.size, element);
    }

    /**
     * 返回index位置对应的元素
     * @param index
     * @return
     */
    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element){
        rangeCheck(index);
        E oldElement = this.elements[index];
        this.elements[index] = element;
        return oldElement;
    }

    /**
     * 往index位置添加元素
     * @param index
     * @param element
     */
    public void add(int index, E element){
        rangeCheckForAdd(index);

        ensureCapacity(this.size+1);
        //移动元素
        for (int i = this.size-1; i >= index; i--) {
            this.elements[i+1] = this.elements[i];
        }
        this.elements[index] = element;
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
            newElements[i] = this.elements[i];
        }
        //替换指针
        this.elements = newElements;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    public void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + this.size);
    }

    public void rangeCheckForAdd(int index){
        if(index < 0 || index > this.size){
            outOfBounds(index);
        }
    }

    public void rangeCheck(int index){
        if(index < 0 || index >= this.size){
            outOfBounds(index);
        }
    }

    /**
     * 删除index位置对应的元素
     * @param index
     * @return
     */
    public E remove(int index){
        rangeCheck(index);
        E oldElement = this.elements[index];

        for (int i = index + 1; i < this.size; i++) {
            this.elements[i-1] = this.elements[i];
        }

        this.elements[--this.size] = null;

        trim();

        return oldElement;
    }

    /**
     * 对动态数组进行缩容
     */
    public void trim(){
        int oldCapacity = this.elements.length;
        int newCapacity = oldCapacity >> 1;
        if(this.size >= newCapacity || oldCapacity <= DEFAULT_CAPACITY) return;

        //按照新容量创建数组
        E[] newElements = (E[])new Object[newCapacity];
        //拷贝元素
        for (int i = 0; i < this.size; i++) {
            newElements[i] = this.elements[i];
        }
        //替换指针
        this.elements = newElements;

        System.out.println(oldCapacity + "缩容为" + newCapacity);


    }

    /**
     * 查看元素的位置
     * @param element
     * @return
     */
    public int indexOf(E element){
        if(element == null){
            for (int i = 0; i < this.size; i++) {
                if(this.elements[i] == null) return i;
            }
        }else{
            for (int i = 0; i < this.size; i++) {
                if(this.elements[i].equals(element)) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("size=").append(size).append(",[");
        for (int i = 0; i < this.size; i++) {
            if(i != 0) str.append(", ");
            str.append(elements[i]);
        }
        str.append("]");
        return str.toString();
    }
}
