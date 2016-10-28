package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)

    {

        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
        System.out.println(isDateOdd("JANUARY 5 2000"));

    }

    public static boolean isDateOdd(String date)
    {
        Date date_now = null;
        Date date_start = null;
        try {
            date_now = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH).parse(date);
            date_start = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(date_now);
        //System.out.println(date_start);

        date_start.setDate(1);
        date_start.setMonth(0);

        //System.out.println(date_start);

        long days = (date_now.getTime()-date_start.getTime())/(24*60*60*1000) + 1;
        //System.out.println("!!" + days);
        if((int)days%2 == 0)
            return false;
        else
            return true;
    }
}
