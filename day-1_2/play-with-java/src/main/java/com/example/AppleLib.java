package com.example;

import java.util.ArrayList;
import java.util.List;

public class AppleLib {

    /**
     *
     * @param input
     * @param predicate
     * @return
     *
     * author : Trainer
     */
    public static List<Apple> filterApples(List<Apple> input, Predicate predicate) {
        List<Apple> output = new ArrayList<>();
        for (Apple apple : input) {
            if (predicate.test(apple)) {
                output.add(apple);
            }
        }
        return output;
    }

    public static List<Apple> filterApplesByColor(List<Apple> input, String color) {
        {
            List<Apple> output = new ArrayList<>();
            for (Apple apple : input) {
                if (apple.getColor().equals(color)) {
                    output.add(apple);
                }
            }
            return output;
        }
    }

    public static List<Apple> filterGreenApples(List<Apple> input) {
        List<Apple> output = new ArrayList<>();
        for (Apple apple : input) {
            if (apple.getColor().equals("green")) {
                output.add(apple);
            }
        }
        return output;
    }

    public static List<Apple> filterRedApples(List<Apple> input) {
        List<Apple> output = new ArrayList<>();
        for (Apple apple : input) {
            if (apple.getColor().equals("red")) {
                output.add(apple);
            }
        }
        return output;
    }

}
