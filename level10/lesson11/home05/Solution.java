package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character, Integer> result = new HashMap<>();
        for(int i = 0; i < abc.length(); i++) {
            result.put(alphabet.get(i), 0);
        }


        for(String list_s: list) {
            for(int i = 0; i < list_s.length(); i++) {
                if(alphabet.contains(list_s.charAt(i))){
                    int num = result.get(list_s.charAt(i));
                    result.put(list_s.charAt(i), num+1);
                }
            }
        }


        for(int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + result.get(alphabet.get(i)));
        }

    }

}
