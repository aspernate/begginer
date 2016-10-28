package com.javarush.test.level08.lesson11.bonus01;

import java.io.*;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        int month_num = 0;
        ArrayList<String> list = new ArrayList<>();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("April");
        list.add("May");
        list.add("June");
        list.add("July");
        list.add("August");
        list.add("September");
        list.add("October");
        list.add("November");
        list.add("December");
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(month)) {
                month_num = i+1;
                break;
            }
        }
        System.out.println(month + " is " + month_num + " month");

    }

}
