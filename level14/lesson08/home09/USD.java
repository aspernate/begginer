package com.javarush.test.level14.lesson08.home09;

/**
 * Created by riabov on 24.05.16.
 */
public class USD extends Money {
    public USD(double amount) {
        super(amount);
    }

    public String getCurrencyName(){
        return "USD";
    }
}
