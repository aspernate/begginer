package com.javarush.test.level31.lesson06.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String pathFile = args[0];
        String pathZip = args[1];

        FileInputStream zipFile = new FileInputStream(pathZip);
        ZipInputStream zipInputStream = new ZipInputStream(zipFile);
        Map<ZipEntry, byte[]> mapZipEntry = new HashMap<>();
        ZipEntry zipEntry;
        while((zipEntry = zipInputStream.getNextEntry()) != null) {
            byte[] b = new byte[zipInputStream.available()];
            zipInputStream.read(b);
            mapZipEntry.put(zipEntry, b);
        }
        zipInputStream.close();
        zipFile.close();


        File zip = new File(pathZip);
        FileOutputStream newZipFile = new FileOutputStream(zip);
        ZipOutputStream zipOutputStream = new ZipOutputStream(newZipFile);
        FileInputStream file = new FileInputStream(pathFile);
        ZipEntry fileEntry = new ZipEntry(new File(pathFile).getName());

        boolean isExist = false;

        for(Map.Entry<ZipEntry, byte[]> entry: mapZipEntry.entrySet()) {
            Path path = Paths.get(entry.getKey().getName());
            if(!(path.getFileName().toString().equals(fileEntry.getName()))) {
                zipOutputStream.putNextEntry(new ZipEntry(entry.getKey().getName()));
                zipOutputStream.write(entry.getValue());
            }
            else {
                isExist = true;
            }
        }

        if(isExist) {
            ZipEntry addingFileEntry = new ZipEntry("new/" + fileEntry.getName());
            zipOutputStream.putNextEntry(addingFileEntry);

            byte[] b = new byte[file.available()];
            file.read(b);

            zipOutputStream.write(b);
            zipOutputStream.closeEntry();
        }

        file.close();
        zipOutputStream.close();
        newZipFile.close();
    }
}
