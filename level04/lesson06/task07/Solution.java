package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] a_s = new String[3];
        int[] a = new int[3];
        int ind1 = 3;
        int ind2 = 3;

        for (int i = 0; i < 3; i++) {
            a_s[i] = reader.readLine();
            a[i] = Integer.parseInt(a_s[i]);
        }
        int b = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j)
                    continue;
                if(a[i] == a[j]) {
                    ind1 = i;
                    ind2 = j;
                }
            }
        }
        System.out.println((3 - ind1 - ind2 + 1));

    }
}
