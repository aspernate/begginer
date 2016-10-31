package com.javarush.test.level04.lesson07.task02;

/* Строка - описание
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание следующего вида:
«четное однозначное число» - если число четное и имеет одну цифру,
«нечетное однозначное число» - если число нечетное и имеет одну цифру,
«четное двузначное число» - если число четное и имеет две цифры,
«нечетное двузначное число» - если число нечетное и имеет две цифры,
«четное трехзначное число» - если число четное и имеет три цифры,
«нечетное трехзначное число» - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае ничего не выводить на экран.
Пример для числа 100:
четное трехзначное число
Пример для числа 51:
нечетное двузначное число
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
        String parity;
        String num;

        if(a%2 == 0)
            parity = "четное";
        else
            parity = "нечетное";

        switch (a_s.length()){
            case 1: num = "однозначное"; break;
            case 2: num = "двузначное"; break;
            case 3: num = "трехзначное"; break;
            default: num = "error"; break;
        }

        if(a > 0 && a < 1000)
            System.out.println(parity + " " + num + " " +"число");

    }
}
