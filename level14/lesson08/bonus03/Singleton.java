package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by riabov on 24.05.16.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
