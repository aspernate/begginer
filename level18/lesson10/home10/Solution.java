package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while(true) {
            String s = reader.readLine();
            if(s.equals("end"))
                break;
            list.add(s);
        }
        reader.close();
        String someName = list.get(0).substring(0, list.get(0).lastIndexOf("part")-1);
        String[] sortList = new String[list.size()+1];
        for(String s: list){
            sortList[Integer.parseInt(s.substring(s.lastIndexOf("part")+4, s.length()))] = s;
        }
        File newFile = new File(someName);
        newFile.createNewFile();
        FileOutputStream fileOutStream = new FileOutputStream(someName);
        for(int i = 1; i < sortList.length; i++) {
            FileInputStream fileInStream = new FileInputStream(sortList[i]);
            byte[] bytes = new byte[fileInStream.available()];
            if(fileInStream.available() > 0) {
                fileInStream.read(bytes);
            }
            fileOutStream.write(bytes);
            fileInStream.close();
        }
        fileOutStream.close();
    }
}
