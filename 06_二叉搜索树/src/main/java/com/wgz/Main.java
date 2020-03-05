package com.wgz;

import com.wgz.printer.BinaryTrees;

import java.util.Comparator;

public class Main {

    private static void testPerson(){
        int[] arr = {7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        for(int i=0;i<arr.length;i++){
            bst.add(new Person(arr[i]));
        }
        BinaryTrees.print(bst);
        System.out.println();

        BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        for(int i=0;i<arr.length;i++){
            bst1.add(new Person(arr[i]));
        }
        BinaryTrees.print(bst1);
    }

    public static void main(String[] args) {
        testPerson();
//        int[] arr = {7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        for(int i=0;i<arr.length;i++){
//            bst.add(arr[i]);
//        }
//        BinaryTrees.print(bst);
//        BinarySearchTree<Person> bst1 = new BinarySearchTree<Person>(new Comparator<Person>(){
//
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });
//        bst1.add(new Person(11));
//        bst1.add(new Person(12));
//        System.out.println(bst1);
//
//        BinarySearchTree<Person> bst2 = new BinarySearchTree<Person>(new Comparator<Person>(){
//
//            public int compare(Person o1, Person o2) {
//                return o2.getAge()-o1.getAge();
//            }
//        });
//        bst2.add(new Person(11));
//        bst2.add(new Person(12));
//        System.out.println(bst2);
    }

}
