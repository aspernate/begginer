package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] a_s = new String[3];
        int[] a = new int[3];
        int pair = 0;
        int pair_val = 0;
        for (int i = 0; i < 3; i++) {
            a_s[i] = reader.readLine();
            a[i] = Integer.parseInt(a_s[i]);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; (j < 3); j++) {
                if(j <= i) continue;
                //System.out.println("!" + a[i] + " " + a[j]);
                if(a[i] == a[j]) {
                    pair += 1;
                    pair_val = a[i];
                }
            }
        }
        if (pair == 1)
            System.out.println(pair_val + " " + pair_val);
        if (pair == 3)
            System.out.println(pair_val + " " + pair_val + " " + pair_val);

    }
}