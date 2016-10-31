package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Set<String> d = new HashSet<>();
        d.add("арбуз");
        d.add("банан");
        d.add("вишня");
        d.add("груша");
        d.add("дыня");
        d.add("ежевика");
        d.add("жень-шень");
        d.add("земляника");
        d.add("ирис");
        d.add("картофель");

        for(String s: d)
            System.out.println(s);

    }
}
