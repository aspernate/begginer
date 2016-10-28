package com.javarush.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sony on 27.08.2016.
 */
public class CurrencyManipulatorFactory
{
    private CurrencyManipulatorFactory()
    {
    }
    private static Map<String,CurrencyManipulator> manipulators = new HashMap<String, CurrencyManipulator>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (manipulators.containsKey(currencyCode))
            return manipulators.get(currencyCode);
        CurrencyManipulator newManipulator = new CurrencyManipulator(currencyCode);
        manipulators.put(currencyCode,newManipulator);
        return newManipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return manipulators.values();
    }
}

