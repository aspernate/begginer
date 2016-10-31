package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufReader.readLine();
        FileInputStream fileReader = new FileInputStream(path);
        int[] arr = new int[256];
        while(fileReader.available()>0){
            int data = fileReader.read();
            arr[data]++;
        }
        int min_num = arr[0];
        for(int a: arr){
            if(a < min_num && a != 0){
                min_num = a;
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == min_num)
                System.out.println(i + " ");
        }


        bufReader.close();
        fileReader.close();
    }
}
