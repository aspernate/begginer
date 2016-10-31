package com.javarush.test.level04.lesson07.task01;

/* Строка - описание
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» - если число отрицательное и четное,
«отрицательное нечетное число» - если число отрицательное и нечетное,
«нулевое число» - если число равно 0,
«положительное четное число» - если число положительное и четное,
«положительное нечетное число» - если число положительное и нечетное.
Пример для числа 100:
положительное четное число
Пример для числа -51:
отрицательное нечетное число
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a_s = new String();
        a_s = reader.readLine();
        int a = Integer.parseInt(a_s);
        String sign;
        String parity;

        if(a%2 == 0)
            parity = "четное ";
        else
            parity = "нечетное ";

        if(a > 0)
            sign = "положительное";
        else if (a < 0)
            sign = "отрицательное";
        else
        {
            sign = "нулевое";
            parity = "";
        }

        System.out.println(sign + " " + parity + "число");
    }
}
