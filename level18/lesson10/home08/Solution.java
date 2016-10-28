package com.javarush.test.level18.lesson10.home08;

import org.w3c.dom.Entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String path = reader.readLine();
            if(path.equals("exit")){
                break;
            }
            else {
                new ReadThread(path).start();
            }
        }
        reader.close();
    }

    public static class ReadThread extends Thread{
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            try {
                FileInputStream fileInStream = new FileInputStream(fileName);
                int[] bytes = new int[256];
                while(fileInStream.available() > 0) {
                    bytes[fileInStream.read()]++;
                }
                fileInStream.close();
                int max = 0;
                int maxByte = 0;
                for(int i = 0; i < bytes.length; i++) {
                    if(bytes[i] > max) {
                        max = bytes[i];
                        maxByte = i;
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileName, maxByte);
                }
            }
            catch (Exception e) {}
        }
    }
}
