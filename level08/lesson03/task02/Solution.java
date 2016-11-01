package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Map<String, String> d = new HashMap<>();
        d.put("арбуз", "ягода");
        d.put("банан", "трава");
        d.put("вишня", "ягода");
        d.put("груша", "фрукт");
        d.put("дыня", "овощ");
        d.put("ежевика", "куст");
        d.put("жень-шень", "корень");
        d.put("земляника", "ягода");
        d.put("ирис", "цветок");
        d.put("картофель", "клубень");
        for(Map.Entry<String, String> pair : d.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

    }
}
