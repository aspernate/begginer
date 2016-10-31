package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static void print(int a){
        System.out.println(a);
    }

    public static void print(Integer a){
        System.out.println(a);
    }

    public static void print(String a){
        System.out.println(a);
    }

    public static void print(int a, int b){
        System.out.println(a + b);
    }

    public static void print(String a, String b){
        System.out.println(a + b);
    }
}
