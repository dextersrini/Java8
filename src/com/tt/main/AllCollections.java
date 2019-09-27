package com.tt.main;

import java.util.*;

public class AllCollections {

    public static void main(String[] args) {
        Map<Integer,String> myMap = new HashMap<Integer,String>();
        for (int i=0;i<10;i++)
            myMap.put(i,i+"hashmap");

        Hashtable<Integer,String> myHashTable = new Hashtable<Integer,String>();
        for (int i=0;i<10;i++)
            myHashTable.put(i,i+"hashtable");

        Set<Integer> myHashSet = new HashSet<Integer>();
        for (int i=0;i<10;i++)
            myHashSet.add(i);

        List<String> myArrayList = new ArrayList<String>();
        for (int i=0;i<10;i++)
            myArrayList.add(i+"arraylist");

        List<String> myLinkedList = new LinkedList<String>();
        for (int i=0;i<10;i++)
            myLinkedList.add(i+"linkedlist");

        Map<Integer, String> myLinkedHashMap = new LinkedHashMap<Integer, String>();
        for (int i=0;i<10;i++)
            myLinkedHashMap.put(i,i+"linkedhashmap");

        Set<String> myLinkedHashSet = new LinkedHashSet<String>();
        for (int i=0;i<10;i++)
            myLinkedHashSet.add(i+"linkedhashset");

        ListIterator<String> myIterator =   myLinkedList.listIterator();
        int j=0;
        while(myIterator.hasNext()) {
            myIterator.next();
            j++;
            if(j==6) {
                myIterator.add("newlyadded");
            }
        }
        System.out.println(myLinkedList.toString());

    }
}
