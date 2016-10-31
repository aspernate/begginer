package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufReader.readLine();
        FileInputStream fileReader = new FileInputStream(path);
        int count = 0;
        while(fileReader.available() > 0){
            if(fileReader.read() == ',')
                count++;
        }
        System.out.println(count);
        bufReader.close();
        fileReader.close();
    }
}
