package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
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
        String path3 = reader.readLine();
        FileOutputStream file1Stream = new FileOutputStream(path1);
        FileInputStream file2Stream = new FileInputStream(path2);
        FileInputStream file3Stream = new FileInputStream(path3);

        byte[] file2 = new byte[file2Stream.available()];
        if(file2Stream.available() > 0) {
            file2Stream.read(file2);
        }
        byte[] file3 = new byte[file3Stream.available()];
        if(file3Stream.available() > 0) {
            file3Stream.read(file3);
        }
        file1Stream.write(file2);
        file1Stream.write(file3);
        reader.close();
        file1Stream.close();
        file2Stream.close();
        file3Stream.close();
    }
}
