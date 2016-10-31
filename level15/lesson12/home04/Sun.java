package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Tony Loner on 27.05.2016.
 */
public class Sun implements Planet
{
    private static Sun  instance;

    private Sun (){}

    public static Sun  getInstance(){
        if(instance == null){
            instance = new Sun ();
        }
        return instance;
    }
}
