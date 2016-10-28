package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] a = new int[1];
            int b = a[1];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new Exception("Ololo1");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new Exception("Ololo2");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new Exception("Ololo3");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("Ololo4");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("Ololo5");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("Ololo6");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("Ololo7");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("Ololo8");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }


    }
}
