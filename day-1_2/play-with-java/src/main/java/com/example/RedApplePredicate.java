package com.example;

public class RedApplePredicate implements Predicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().endsWith("red");
    }
}
