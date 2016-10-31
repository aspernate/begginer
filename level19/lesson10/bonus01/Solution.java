package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();
        while(readerFile1.ready()){
            file1.add(readerFile1.readLine());
        }
        while(readerFile2.ready()){
            file2.add(readerFile2.readLine());
        }
        reader.close();
        readerFile1.close();
        readerFile2.close();
        int i = 0;
        int j = 0;
        while(true) {
            if(i >= file1.size() && j >= file2.size()){
                break;
            }

            else if(i == file1.size()-1) {
                if(file1.get(i).equals(file2.get(j))) {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    lines.add(new LineItem(Type.ADDED, file2.get(j+1)));
                    break;
                }
                else {
                    lines.add(new LineItem(Type.ADDED, file2.get(j)));
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    break;
                }
            }

            else if(j == file2.size() - 1){
                if(file1.get(i).equals(file2.get(j))) {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    lines.add(new LineItem(Type.REMOVED, file1.get(i+1)));
                    break;
                }
                else {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    lines.add(new LineItem(Type.SAME, file2.get(j)));
                    break;
                }
            }


            else if(file1.get(i).equals(file2.get(j))){
                lines.add(new LineItem(Type.SAME, file1.get(i)));
                i++;
                j++;
                continue;
            }
            else if (file1.get(i).equals(file2.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED, file2.get(j)));
                j++;
                continue;
            }
            else if(file1.get(i+1).equals(file2.get(j))) {
                lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                i++;
                continue;
            }
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

}
