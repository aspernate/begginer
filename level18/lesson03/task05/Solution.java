package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufReader.readLine();
        FileInputStream fileReader = new FileInputStream(path);
        ArrayList<Integer> list = new ArrayList<>();
        while(fileReader.available() > 0){
            int data = fileReader.read();
            if(!list.contains(data)){
                list.add(data);
            }
        }
        Collections.sort(list);
        for(Integer a: list)
            System.out.print(a + " ");

        bufReader.close();
        fileReader.close();
    }
}
