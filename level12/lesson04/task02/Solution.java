package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int a = 5;
        Integer b = 7;
       print(a);
        print(b);

    }

    public static void print(int a){
        System.out.println(a);
    }

    public static void print(Integer a){
        System.out.println(a);
    }
}
