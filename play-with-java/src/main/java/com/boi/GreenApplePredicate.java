package com.boi;

import com.boi.model.Apple;

public class GreenApplePredicate implements Predicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}
