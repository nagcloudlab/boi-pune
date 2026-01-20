package com.boi.model;

public class Apple {

    private String color;
    private int weight;

    public Apple(String color,int weight){
        this.color=color;
        this.weight=weight;
    }

    public String getColor() {
        return color;
    }
    public int getWeight() {
        return weight;
    }

    // toString method
    @Override
    public String toString() {
        return "Apple [color=" + color + ", weight=" + weight + "]";
    }

}
