package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        FileInputStream file1InStream = new FileInputStream(path1);
        byte[] file1 = new byte[file1InStream.available()];
        if(file1InStream.available() > 0){
            file1InStream.read(file1);
        }
        file1InStream.close();
        String str = new String(file1, "UTF-8");
        String strNew = "";
        StringTokenizer st = new StringTokenizer(str, " ");
        while(st.hasMoreTokens()){
            strNew = strNew + Math.round(Float.parseFloat(st.nextToken())) + " ";
        }
        byte[] file1New = strNew.substring(0, strNew.length()-1).getBytes();

        FileOutputStream file2OutStream = new FileOutputStream(path2);
        file2OutStream.write(file1New);
        reader.close();
        file2OutStream.close();

    }
}
