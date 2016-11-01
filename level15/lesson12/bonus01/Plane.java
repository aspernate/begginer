package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Tony Loner on 28.05.2016.
 */
public class Plane implements Flyable {
    public int pass = 0;
    public void fly(){}
    public Plane(int pass) {
        this.pass = pass;
    }
}
