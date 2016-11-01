package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] s_ch = s.toCharArray();
        if(s_ch[0] != ' ')
            s_ch[0] = Character.toUpperCase(s_ch[0]);
        for(int i = 1; i < s.length(); i++){
            if(s_ch[i-1] == ' ' && s_ch[i] != ' ')
                s_ch[i] = Character.toUpperCase(s_ch[i]);
        }
        s = String.valueOf(s_ch);
        System.out.println(s);

    }


}
