package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String path3 = bufReader.readLine();
        FileInputStream fileReader = new FileInputStream(path1);
        FileOutputStream fileWriter2 = new FileOutputStream(path2);
        FileOutputStream fileWriter3 = new FileOutputStream(path3);
        int bytes = fileReader.available();
        int bytes2 = 0;
        int bytes3 = 0;
        byte[] file1 = new byte[bytes];
        fileReader.read(file1);
        bytes2 = bytes/2;
        bytes3 = bytes/2;
        if(bytes%2 != 0) bytes2 = bytes2+1;
        if(bytes2 > 0){
            fileWriter2.write(file1, 0, bytes2);
        }
        if(bytes3 > 0) {
            fileWriter3.write(file1, bytes2, bytes3);
        }
        bufReader.close();
        fileReader.close();
        fileWriter2.close();
        fileWriter3.close();
    }
}
