package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        switch (args[0]) {
            case "-u": {
                BufferedReader fileReader = new BufferedReader(new FileReader(path));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path + "~"));
                String line;
                while((line = fileReader.readLine()) != null) {
                    int id = Integer.parseInt(line.substring(0, 8).replaceAll(" ", ""));
                    if(id != Integer.parseInt(args[1])){
                        fileWriter.write(line + "\n");
                    }
                    else {
                        fileWriter.write(strCompleteSpace(args[1], 8) + strCompleteSpace(args[2], 30) + strCompleteSpace(args[3], 8) + strCompleteSpace(args[4], 4) + "\n");
                    }
                }
                fileWriter.close();
                fileReader.close();
                File file = new File(path);
                File fileTemp = new File(path + "~");
                fileTemp.renameTo(file);
                fileTemp.delete();
                break;
            }
            case  "-d": {
                BufferedReader fileReader = new BufferedReader(new FileReader(path));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path + "~"));
                String line;
                while((line = fileReader.readLine()) != null) {
                    int id = Integer.parseInt(line.substring(0, 8).replaceAll(" ", ""));
                    if(id != Integer.parseInt(args[1])){
                        fileWriter.write(line + "\n");
                    }
                }
                fileWriter.close();
                fileReader.close();
                File file = new File(path);
                File fileTemp = new File(path + "~");
                fileTemp.renameTo(file);
                fileTemp.delete();
                break;
            }
        }
    }

    public static String strCompleteSpace(String str, int length){
        if(str.length() < length) {
            for (int i = str.length(); i < length; i++) {
                str = str + " ";
            }
        }
        else {
            str = str.substring(0, length);
        }
        return str;
    }
}
