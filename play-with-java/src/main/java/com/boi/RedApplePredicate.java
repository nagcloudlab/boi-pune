package com.boi;

import com.boi.model.Apple;

public class RedApplePredicate implements Predicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().endsWith("red");
    }
}
