package com.tt.main;

import javax.smartcardio.Card;
import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

public class LambdaExpressions {

    interface Testing {
        String test(String item);
    }
    public static void main(String[] args) {

        //Example 1
        Testing test = (String item) -> {
            return item;
        };
        System.out.println("Example 1");
        System.out.println(test.test("Test"));
        //Example 2
        LambdaCalculator lC = new LambdaCalculator();
        LambdaCalculator.Calc cAdd = (a,b)->a+b;
        LambdaCalculator.Calc cSub = (a,b)->a-b;
        System.out.println("Example 2");
        System.out.println(lC.doCalc(10,20,(a,b)-> a-b));
        System.out.println(lC.doCalc(10,20,(a,b)->a*b));
        System.out.println(lC.doCalc(10,20,cSub));
        //Example 3
        System.out.println("Example 3");
        try {
            new LambdaInitialization().testInitialize();
        }catch(Exception er){}
        //Example 4
        System.out.println("Example 4");
        new LambdaSorting().testCarsSorting();
        //Example 4
        System.out.println("Example 5");
        new LambdaPredicates().testPredicates();
    }
}

/**
 * Lambda expression as a calculator
 */
class LambdaCalculator {
    public interface Calc {
        int calcmethod(int a, int b);
    }
    public int doCalc(int a, int b, Calc calc) {
        return calc.calcmethod(a,b);
    }
}

/**
 * Initialize with an implementation as a value
 */
class LambdaInitialization {
    public void testInitialize() throws Exception{
        Callable[] callables = new Callable[]{()->{return Math.random();}, ()->"Cat"};
        System.out.println(callables[0].call());

    }
}

class LambdaSorting {

    public void testCarsSorting() {
        Cars[] carArray = new Cars[] {new Cars("Maruti"),
        new Cars("Honda"), new Cars("Hyundai")};
        System.out.println("Arrays Before Sorting :: " + Arrays.toString(carArray));
        Arrays.sort(carArray, Cars::carsCompare);
        System.out.println("Arrays After Sorting :: " + Arrays.toString(carArray));
    }

    static class Cars {
        String carname;
        Cars(String carname) {
            this.carname=carname;
        }
        public static int carsCompare(Cars c1, Cars c2) {
            return c1.carname.compareTo(c2.carname);
        }
        public String toString() {
            return this.carname;
        }
    }
}

class LambdaPredicates {
    public void testPredicates() {
        List<Integer> ageList = new ArrayList<Integer>();
        ageList.add(new Integer(10));
        ageList.add(new Integer(30));
        ageList.add(new Integer(99));
        ageList.add(new Integer(9));

        System.out.println("Add All Ages ::" + conditionalAdd(ageList, a -> true));
        System.out.println("Dont add any ages ::" + conditionalAdd(ageList, b -> false));
        System.out.println("Add if age less than 50 ::" + conditionalAdd(ageList, b -> b < 50));
        System.out.println("Add if age is negative ::" + conditionalAdd(ageList, b -> b < 0));
    }

    int conditionalAdd(List<Integer> ageList, Predicate<Integer> predicate) {
        int sum=0;
        for(int age : ageList) {
            if (predicate.test(age))
                sum+=age;
        }
        return sum;
    }
}
