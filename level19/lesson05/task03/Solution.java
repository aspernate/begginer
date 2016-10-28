package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        char[] buffer = new char[(int)file1.length()];
        fileReader.read(buffer);
        fileReader.close();
        String str = new String(buffer);
        StringTokenizer st = new StringTokenizer(str, " \n");
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            try {
                fileWriter.write(String.valueOf(Integer.parseInt(s)) + " ");
            }
            catch (NumberFormatException e){ }
        }
        fileReader.close();
        fileWriter.close();
    }
}
