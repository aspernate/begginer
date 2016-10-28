package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        FileReader fileReader = new FileReader(file);
        char[] buffer = new char[(int)file.length()];
        int count = 0;
        fileReader.read(buffer);
        fileReader.close();
        String str = new String(buffer);
        StringTokenizer st = new StringTokenizer(str, " \t\n\r,.");
        while(st.hasMoreTokens()){
            if(st.nextToken().equals("world"))
                count++;
        }
        System.out.println(count);

    }
}
