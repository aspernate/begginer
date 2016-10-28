package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        String path = "";
        try {
            path = bufReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader fileReader = null;

        try {
            fileReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";

        String file = "";
        try {
            while((line = fileReader.readLine()) != null ) {
                file = file + " " + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = file.split(" ");

        ArrayList<String> wordsList = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            if(!words[i].equals("") && !words[i].contains(" ")) {
                wordsList.add(words[i]);
            }
        }

        int i = 0;
        boolean find = false;
        while(true) {
            find = false;
            for(int j = i+1; j < wordsList.size(); j++) {
                if(wordsList.get(i).equals((new StringBuilder(wordsList.get(j))).reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = wordsList.get(i);
                    pair.second = wordsList.get(j);
                    result.add(pair);
                    wordsList.remove(j);
                    wordsList.remove(i);
                    find = true;
                    break;
                }
            }
            if(!find) {
                i++;
            }
            if(i >= wordsList.size())
                break;

        }

        for(Pair p: result) {
            System.out.println(p.toString());
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
