package com.javarush.test.level32.lesson02.task01;

import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        long length = raf.length();
        if(Long.parseLong(args[1]) > length) {
            raf.seek(length);
        }
        else {
            raf.seek(Long.parseLong(args[1]));
        }
        raf.write(args[2].getBytes());
        raf.close();
    }
}
