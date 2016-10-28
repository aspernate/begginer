package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> list = new HashSet();
        Random r = new Random();
        list.add("Л1");
        list.add("Л2");
        list.add("Л3");
        list.add("Л4");
        list.add("Л5");
        list.add("Л6");
        list.add("Л7");
        list.add("Л8");
        list.add("Л9");
        list.add("Л10");
        list.add("Л11");
        list.add("Л12");
        list.add("Л13");
        list.add("Л14");
        list.add("Л15");
        list.add("Л16");
        list.add("Л17");
        list.add("Л18");
        list.add("Л19");
        list.add("Л20");
        return list;
    }
}
