package com.tt.ds;
public class MyLinkedList<D> {

    transient Node<D> first;
    transient Node<D> last;
    transient int size = 0;

    //constructor
    public MyLinkedList(){

    }

    //add public method
    public boolean add(D dataItem) {

//        if (next == null)
        addLast(dataItem);
        return true;
    }

    //default add to last
    private void addLast(D dataItem) {
        final Node<D> l = last;
        final Node<D> newNode = new Node<D>(l,dataItem);
        last=newNode;
        if(l == null)
            first=newNode;
        else
            l.nextAdd=newNode;
        size++;
    }

    //Node Class
    private static class Node<D> {
        private D dataItem;
        private Node<D> nextAdd;
        Node(Node<D> nextAdd, D dataItem) {
            this.dataItem=dataItem;
            this.nextAdd=nextAdd;
        }

        //getDataItem
        public D getDataItem() {
            return dataItem;
        }
        //get NextAddress
        public Node<D> getNextAdd() {
            return nextAdd;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myownLinkedList = new MyLinkedList<Integer>();
        myownLinkedList.add(10);
        myownLinkedList.add(20);
    }
}