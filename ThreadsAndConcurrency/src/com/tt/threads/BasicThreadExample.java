package com.tt.threads;

/**
 * Main class
 */
public class BasicThreadExample {
    public static void main(String[] args) {

        //Create thread using the Implements Runnable Interface

        //Create Thread one
        Thread one = new Thread(new ThreadRunnerImplements(2));
        //Create Thread two
        Thread two = new Thread(new ThreadRunnerImplements(3));
        //start both the threads for a race condition print
        one.start();
        two.start();

        //Create thread using the Extends Thread Class
        Thread three = new ThreadRunnerExtends();
        three.start();
    }

/**
* Class declared static for use from the static main method
*/
static class ThreadRunnerImplements implements  Runnable {
    protected Integer counter=0;
    protected Integer val;
    ThreadRunnerImplements(Integer val) {
        this.val=val;
    }
    @Override
    public void run() {
        add(this.val);
        System.out.println("Inside the ThreadRunnerImplements Run Method" + this.counter);
    }
    public void add(Integer val) {  //When you make this method synchronized, then the race condition is taken care of
        this.counter = this.counter+val;
    }
}

/**
* Class declared static for use from the static main method
* Thread class using Thread Extends
*/
static class ThreadRunnerExtends extends  Thread {
  public void run() {
      System.out.println("Inside the ThreadRunnerExtends Run method");
  }
}
}
