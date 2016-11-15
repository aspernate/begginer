package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        ArrayDeque<File> queue = new ArrayDeque<>();
        File rootFolder = new File(root);
        queue.addLast(rootFolder);
        while (queue.size()> 0) {
            File fileElem = queue.pollFirst();
            for(File file: fileElem.listFiles()) {
                if(file.isFile()) {
                    result.add(file.getAbsolutePath());
                } else {
                    queue.addLast(file);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try
        {
            List<String>list = getFileTree("C://temp");
            for(String str: list) {
                System.out.println(str);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
