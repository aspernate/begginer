package com.javarush.test.level04.lesson10.task01;

import java.io.*;

/* 10 чисел
Вывести на экран числа от 1 до 10 используя цикл while.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String num_s = reader.readLine();
        int num = Integer.parseInt(num_s);
        for (int i = 0; i < num; i++)
            System.out.println(text);

    }
}