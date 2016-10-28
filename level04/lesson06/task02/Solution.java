package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] a_s = new String[4];
        int[] a = new int[4];
        int max;
        for (int i = 0; i < 4; i++) {
            a_s[i] = reader.readLine();
            a[i] = Integer.parseInt(a_s[i]);
        }
        max = a[0];
        for (int i = 1; i < 4; i++) {
            if(a[i] > max)
                max = a[i];
        }
        System.out.println(max);

    }
}
