package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bufReader.readLine();
        String path2 = bufReader.readLine();
        FileInputStream fileReader = new FileInputStream(path1);
        FileOutputStream fileWriter = new FileOutputStream(path2);
        byte[] file1 = new byte[fileReader.available()];
        byte[] file2 = new byte[file1.length];
        fileReader.read(file1);
        for(int i = 0; i < file1.length; i++) {
            file2[i] = file1[file1.length-1-i];
        }
        fileWriter.write(file2);
        bufReader.close();
        fileReader.close();
        fileWriter.close();
    }
}
