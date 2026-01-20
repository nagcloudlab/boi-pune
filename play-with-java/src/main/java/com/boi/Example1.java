package com.boi;

import com.boi.model.Apple;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {


        List<Apple> inventory = List.of(
                new Apple("green", 150),
                new Apple("red", 100),
                new Apple("green", 200));


        // Req-1 : filter green apples

        List<Apple> result = AppleLib.filterApples(inventory, new GreenApplePredicate());
        System.out.println(result);


        // Req2 : filter red apples
        result = AppleLib.filterApples(inventory, new RedApplePredicate());
        System.out.println(result);

        // Req3 : filter heavy-weight Apples ( > 150 )
        result = AppleLib.filterApples(inventory, new Predicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        System.out.println(result);

        // Java-8 : Lambda aka function
        // Req3 : filter apples with weight 200g
        result = AppleLib.filterApples(inventory, apple -> apple.getWeight() == 200);


    }


}


// style of coding
// imperative style
// -> solving problem using ste-by-step approach
// -> intention + implementation mixed together

// solution:
// declarative style
// - by param(s)
//        -> value | object
// intention & implementation separated..