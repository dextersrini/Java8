package com.tt.main;

import java.util.ArrayList;
import java.util.*;
import java.util.function.Consumer;

public class IteratorForEachImpl {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        for (int i=0;i<10;i++) myList.add(i);
        Iterator<Integer> myIt = myList.iterator();
        while(myIt.hasNext()) {
            Integer i = myIt.next();
            System.out.println(i);
        }
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Changed value is ::" + integer);
            }
        });
        MyConsumer consumer = new MyConsumer();
        myList.forEach(consumer);
    }
}
//Consumer isolated implementation
class MyConsumer implements Consumer<Integer> {
    public void accept(Integer integer) {
        System.out.println("My own implementation value is ::: "  + integer);
    }
}
