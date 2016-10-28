package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        FileInputStream file1InStream = new FileInputStream(path1);
        FileInputStream file2Stream = new FileInputStream(path2);

        byte[] file1 = new byte[file1InStream.available()];
        if(file1InStream.available() > 0) {
            file1InStream.read(file1);
        }
        byte[] file2 = new byte[file2Stream.available()];
        if(file2Stream.available() > 0) {
            file2Stream.read(file2);
        }
        FileOutputStream file1OutStream = new FileOutputStream(path1);
        file1OutStream.write(file2);
        file1OutStream.write(file1);
        reader.close();
        file1InStream.close();
        file1OutStream.close();
        file2Stream.close();

    }
}
