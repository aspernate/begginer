package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a_s = reader.readLine();
        int a = Integer.parseInt(a_s);
        String b_s = reader.readLine();
        int b = Integer.parseInt(b_s);
        if(a <= b)
            System.out.println(a);
        else if (a > b)
            System.out.println(b);


    }
}