package com.tt.ds;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyBinaryTree {
    Node root;
    static class Node {
        transient Integer data;
        transient Node left;
        transient Node right;
        Node(Integer data) {
            this.data=data;
            left = right = null;
        }
    }

    private Node addRecursive(Node current, Integer data) {
        if (current == null)
            return new Node(data);
        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }
        return current;
    }

    public void add(Integer data) {
        root = addRecursive(root, data);
    }

    private boolean containsRecursive(Node current, Integer dataToFind) {
        if (current == null)
            return false;
        if (dataToFind.equals(current.data))
            return true;
        return dataToFind < current.data ? containsRecursive(current.left, dataToFind) : containsRecursive(current.right, dataToFind);
    }

    public boolean contains(Integer dataToFind) {
        return containsRecursive(root, dataToFind);
    }

    //get the smallest value of any node
    private Integer findSmallest(Node root) {
        return root.left == null ? root.data : findSmallest(root.left);
    }

    private Node deleteRecursive(Node current, Integer dataToDel) {
        if(current == null)
            return null;
        if (dataToDel == current.data) {
            //Three kinds of logic has to go here
            //logic one if there are no child nodes.
            if (current.left == null && current.right == null)
                return null;
            //logic 2 if the node has either left or right child
            if (current.left == null)
                return current.right;
            if (current.right == null)
                return current.left;
            //logic 3 if the node has both left and right child
            if (current.left != null && current.right != null) {
                Integer smallestValue = findSmallest(current.right);
                current.data = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
            }
        }
        if (dataToDel < current.data) {
            current.left = deleteRecursive(current.left, dataToDel);
        }
        else if (dataToDel > current.data) {
            current.right = deleteRecursive(current.right, dataToDel);
        }

        return current;
    }

    public void delete(Integer dataTodel) {
        root = deleteRecursive(root, dataTodel);
    }

    public void traverseInorder(Node node) {
        if (node != null) {
            traverseInorder(node.left);
            System.out.print(" " + node.data);
            traverseInorder(node.right);
        }
    }

    public int findHeight(Node root) {
        if(root == null)
            return -1;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight,rightHeight) + 1;

    }

    public void traversePreOrder(Node node) {
        if (node == null) return;
        System.out.print(" " + node.data);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public void traversePostOrder(Node node) {
        if (node == null) return;
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.print(" " + node.data);
    }

    public void levelOrderTraversal(Node node) {
        Queue<Node> tempQueue =  new LinkedBlockingQueue<Node>();
        if (node != null)
            tempQueue.add(node);
        else
            return;
        Node current;
        while (!tempQueue.isEmpty()) {
            current = tempQueue.poll();
            System.out.print(" " + current.data);
            if (current.left != null)
                tempQueue.add(current.left);
            if (current.right != null)
                tempQueue.add(current.right);
        }
    }

    public static void main(String[] args) {
        MyBinaryTree myBTree = new MyBinaryTree();

        //test add
        myBTree.add(10);
        myBTree.add(30);
        myBTree.add(2);
        myBTree.add(5);
        myBTree.add(4);
        myBTree.add(50);
        myBTree.add(6);
        myBTree.add(13);
        myBTree.add(40);
        myBTree.add(7);

        //myBTree.delete(30   );

//        myBTree.traverseInorder(myBTree.root);

//        System.out.println(myBTree.contains(2));
//        System.out.println(myBTree.contains(13));
//
//        System.out.println(myBTree.findHeight(myBTree.root));

        //myBTree.traversePreOrder(myBTree.root);

        System.out.println("\nLevel Order traversal");
        myBTree.levelOrderTraversal(myBTree.root);
        System.out.println("\nIn Order Traversal");
        myBTree.traverseInorder(myBTree.root);
        System.out.println("\nPre Order Traversal");
        myBTree.traversePreOrder(myBTree.root);
        System.out.println("\nPost Order Traversal");
        myBTree.traversePostOrder(myBTree.root);


    }
}
