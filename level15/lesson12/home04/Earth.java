package com.javarush.test.level15.lesson12.home04;

/**
 * Created by riabov on 25.05.16.
 */
public class Earth {
    private static Earth ourInstance = new Earth();

    public static Earth getInstance() {
        return ourInstance;
    }

    private Earth() {
    }
}
