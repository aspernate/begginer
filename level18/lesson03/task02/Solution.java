package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufReader.readLine();
        FileInputStream fileReader = new FileInputStream(path);
        int min = fileReader.read();
        while(fileReader.available() > 0) {
            int data = fileReader.read();
            if (data < min)
                min = data;
        }
        System.out.println(min);
        bufReader.close();
        fileReader.close();
    }
}
