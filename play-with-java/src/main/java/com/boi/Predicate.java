package com.boi;

import com.boi.model.Apple;

@FunctionalInterface
// SAM -> Single Abstract Method
public interface Predicate {
    boolean test(Apple apple);
}
