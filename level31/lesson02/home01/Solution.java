package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {
        try {
            List<File> files = getFileTree(args[0]);
            Collections.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            File inputFile = new File(args[1]);
            File outputFile = new File(inputFile.getParent() + "/allFilesContent.txt");
            inputFile.renameTo(outputFile);

            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

            for(int i = 0; i < files.size(); i++) {
                File file = files.get(i);
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] buffer = new byte[(int)file.length()];
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
                if(i != files.size()-1)
                fileOutputStream.write('\n');
                fileInputStream.close();
            }

            fileOutputStream.close();

            deleteEmptyDir(args[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmptyDir(String root) throws IOException {
        ArrayDeque<File> queue = new ArrayDeque<>();
        File rootFolder = new File(root);
        queue.addLast(rootFolder);
        while (queue.size()> 0) {
            File fileElem = queue.pollFirst();
            for(File file: fileElem.listFiles()) {
                if(file.isDirectory()) {
                    if(file.listFiles().length == 0) {
                        file.delete();
                    }
                    else {
                        queue.addLast(file);
                    }
                }
            }
        }
    }

    public static List<File> getFileTree(String root) throws IOException {
        List<File> result = new ArrayList<>();
        ArrayDeque<File> queue = new ArrayDeque<>();
        File rootFolder = new File(root);
        queue.addLast(rootFolder);
        while (queue.size()> 0) {
            File fileElem = queue.pollFirst();
            for(File file: fileElem.listFiles()) {
                if(file.isFile()) {
                    if(file.length() > 50)
                        file.delete();
                    else
                        result.add(file);
                } else {
                    queue.addLast(file);
                }
            }
        }
        return result;
    }
}
