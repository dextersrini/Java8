package com.tt.main;

import java.sql.Statement;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Predicate;

public class JavaNativeDataStructures {
    public static void main(String[] args) {

        System.out.println("Simple Stack Implementation \n");

        /**
         * Defining Simple Stack and putting elements into it.
         */
        Stack mySimpleStack = new Stack();
        mySimpleStack.push(10);
        mySimpleStack.push(30);
        int stackSize = mySimpleStack.size();
        System.out.println(mySimpleStack.size());
        mySimpleStack.stream().forEach(o->{System.out.println(o);});
        for (int i = 0; i < stackSize; i++) {
            System.out.println(mySimpleStack.pop());
        }

        System.out.println("Queue with LinkedList Implementation \n");
        /**
         * Defining Simple Queue and putting elements inside.
         */
        Queue simpleQ = new LinkedList();
        simpleQ.add(10);
        simpleQ.add(40);
        simpleQ.add(70);

        /**
         * Just stream all the data of the Queue
         */
        simpleQ.stream().forEach(o->{System.out.println(((Integer) o));});

        /**
         * User stream and filter to filter one record and print the same.
         */
        simpleQ.stream().filter(new Predicate() {
            @Override
            public boolean test(Object o) {
                if (((Integer) o) == 40)
                    return true;
                else
                    return false;
            }
        }).forEach(o -> {System.out.println(((Integer) o));});

        /**
         * Verifying that even after using stream the data size of the Q remains same.
         */

        System.out.println(simpleQ.size());

        /**
         * Perform forloop and dequeue from Q
         */

        while(simpleQ.size() != 0) {
            System.out.println(simpleQ.remove());
        }


        System.out.println("Java Dequeue as Queue or stack usage Implementation \n");
        Deque<Integer> myLinkedBlockingDequeue = new LinkedBlockingDeque<Integer>();
        Deque<Integer> myDequeue = new LinkedList<Integer>();
        myDequeue.add(10);
        myDequeue.add(20);
    }
}
