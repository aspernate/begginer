package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by riabov on 18.11.16.
 */
public abstract class ZipCommand implements Command{
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        String pathArc = ConsoleHelper.readString();
        Path path = Paths.get(pathArc);
        return new ZipFileManager(path);
    }
}
