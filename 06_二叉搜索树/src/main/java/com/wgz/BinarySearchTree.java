package com.wgz;

import com.wgz.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * 二叉搜索树
 * @param <E>
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;

    private Comparator comparator;

    public BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator comparator){
        this.comparator = comparator;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void add(E element){
        elementNotNullCheck(element);
        //添加第一个节点
        if(root==null){
            root = new Node<E>(element, null);
            this.size++;
            return;
        }

        //如果添加的不是第一个节点
        Node<E> node = root;
        Node<E> parent = null;
        int result = 0;
        while(node != null){
            result = compare(element, node.element);
            parent = node;
            if(result>0){
                node = node.right;
            }else if(result<0){
                node = node.left;
            }else{
                return;
            }
        }

        //看看插入到父节点的哪个位置
        Node<E> newNode = new Node<E>(element, parent);
        if(result>0){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }

        this.size++;

    }

    /**
     * 比较两个元素的大小
     * @param element
     * @param element1
     * @return
     */
    private int compare(E element, E element1) {
        if(this.comparator != null){
            return this.comparator.compare(element, element1);
        }

        return ((Comparable<E>)element).compareTo(element1);

    }

    private void elementNotNullCheck(E element) {
        if(element==null){
            throw new IllegalArgumentException("element must not be null");
        }
    }


    public void preorder(Visitor<E> visitor){
        preorder(root, visitor);
    }

    public void preorder(Node<E> node,Visitor<E> visitor){
        visitor.visit(node.element);
        preorder(node.left, visitor);
        preorder(node.right, visitor);
    }

    public void inorder(Visitor<E> visitor){
        inorder(root, visitor);
    }

    public void inorder(Node<E> node,Visitor<E> visitor){
        preorder(node.left, visitor);
        visitor.visit(node.element);
        preorder(node.right, visitor);
    }

    public void postorder(Visitor<E> visitor){
        postorder(root, visitor);
    }

    public void postorder(Node<E> node,Visitor<E> visitor){
        postorder(node.left, visitor);
        postorder(node.right, visitor);
        visitor.visit(node.element);
    }

    public Object root() {
        return this.root;
    }

    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if(myNode.parent != null){
            parentString = myNode.parent.element.toString();
        }
        return ((Node<E>)node).element + "_p("+parentString+")";
    }

    public interface Visitor<E>{
        void visit(E e);
    }


    private static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent){
            this.element = element;
            this.parent = parent;
        }

    }

}
