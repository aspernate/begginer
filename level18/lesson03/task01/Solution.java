package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufReader.readLine();
        FileInputStream fileReader = new FileInputStream(path);
        int max = 0;
        while(fileReader.available() > 0) {
            int data = fileReader.read();
            if (data > max)
                max = data;
        }
        System.out.println(max);
        bufReader.close();
        fileReader.close();
    }
}
