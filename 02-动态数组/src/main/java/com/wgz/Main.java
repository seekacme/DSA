package com.wgz;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList2<Integer> list = new ArrayList2<Integer>();

        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        for (int i = 0; i < 50; i++) {
            list.remove(0);
        }

        System.out.println(list);



    }

}
