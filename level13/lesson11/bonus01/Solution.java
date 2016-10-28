package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader filereader = new BufferedReader(new FileReader(path));
        String line;
        while((line = filereader.readLine()) != null) {
            list.add(Integer.valueOf(line));
        }
        Collections.sort(list);
        for(Integer a: list) {
            if(a%2 == 0)
                System.out.println(a);
        }

    }
}
