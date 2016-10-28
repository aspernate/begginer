package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Objects;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<>();
        int[] ar5 = {5,4,3,2,1};
        int[] ar2 = {2,1};
        int[] ar4 = {4,3,2,1};
        int[] ar7 = {7,6,5,4,3,2,1};
        int[] ar0 = {};
        list.add(ar5);
        list.add(ar2);
        list.add(ar4);
        list.add(ar7);
        list.add(ar0);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
