package com.example;

@FunctionalInterface
// SAM -> Single Abstract Method
public interface Predicate {
    boolean test(Apple apple);
}
