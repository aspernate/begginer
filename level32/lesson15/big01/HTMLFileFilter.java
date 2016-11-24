package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by riabov on 23.11.16.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String name = f.getName().toLowerCase();
        if(f.isDirectory() || name.endsWith(".html") || name.endsWith(".htm"))
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
