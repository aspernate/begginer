package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] a_s = new String[3];
        int[] a = new int[3];
        int max;
        for (int i = 0; i < 3; i++) {
            a_s[i] = reader.readLine();
            a[i] = Integer.parseInt(a_s[i]);
        }
        int b;
        for(int j = 0; j < 2; j++) {
            for (int i = 1; i < 3; i++) {
                if (a[i] > a[i-1]) {
                    b = a[i];
                    a[i] = a[i-1];
                    a[i-1] = b;
                }

            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(a[i]);
            if(i != 2)
                System.out.print(" ");
        }

    }
}
