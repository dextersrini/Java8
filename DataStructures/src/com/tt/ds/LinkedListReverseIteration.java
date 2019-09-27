package com.tt.ds;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListReverseIteration {

    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        ListIterator<Integer> myLLIter = myLinkedList.listIterator();
    }
}
