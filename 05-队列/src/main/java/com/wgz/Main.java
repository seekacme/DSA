package com.wgz;

import com.wgz.circle.CircleDeque;
import com.wgz.circle.CircleQueue;

public class Main {

    public static void main(String[] args) {
        test_circleDeque();
    }

    static void test_circleDeque() {
        CircleDeque<Integer> queue = new CircleDeque<Integer>();
        // 头5 4 3 2 1  100 101 102 103 104 105 106 8 7 6 尾

        // 头 8 7 6  5 4 3 2 1  100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }

        // 头 null 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null null 尾
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }
//
//        // 头 11 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null 12 尾
        queue.enQueueFront(11);
        queue.enQueueFront(12);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueFront());
        }
    }

    private static void test_circleQueue(){
        CircleQueue<Integer> queue = new CircleQueue<Integer>();

        // 0 1 2 3 4 null null null null null
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }

        // null null 2 3 4 null null null null null
        for (int i = 0; i < 2; i++) {
            System.out.println(queue.deQueue());
        }
        // 10 11 2 3 4 5 6 7 8 9
        for (int i = 5; i < 15; i++) {
            queue.enQueue(i);
        }

        // 10 11 2 3 4 5 6 7 8 9
        System.out.println(queue);

        //2 3 4 5 6 7 8 9 10 11
        while(!queue.isEmpty()){
            System.out.println(queue.deQueue());
        }
    }

    private static void test_deque1(){
        Deque<Integer> queue = new Deque<Integer>();
        queue.enQueueRear(10);
        queue.enQueueRear(20);
        queue.enQueueRear(30);
        queue.enQueueRear(40);
        queue.enQueueRear(50);

        while(!queue.isEmpty()){
            System.out.println(queue.deQueueFront());
        }
    }

    private static void test_deque2(){
        Deque<Integer> queue = new Deque<Integer>();
        queue.enQueueFront(10);
        queue.enQueueFront(20);
        queue.enQueueFront(30);
        queue.enQueueFront(40);
        queue.enQueueFront(50);

        while(!queue.isEmpty()){
            System.out.println(queue.deQueueRear());
        }
    }

    private static void test_queue(){
        Queue<Integer> queue = new Queue<Integer>();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);

        while(!queue.isEmpty()){
            System.out.println(queue.deQueue());
        }
    }

}
