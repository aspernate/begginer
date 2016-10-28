package com.javarush.test.level15.lesson12.home04;

/**
 * Created by riabov on 25.05.16.
 */
public class Sun {
    private static Sun ourInstance = new Sun();

    public static Sun getInstance() {
        return ourInstance;
    }

    private Sun() {
    }
}
