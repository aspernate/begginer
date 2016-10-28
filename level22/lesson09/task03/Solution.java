package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        //...
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
                file = file + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = file.split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        StringBuilder output = new StringBuilder();

        ArrayList<String> wordsList = new ArrayList<>();
        ArrayList<String> wordsL = new ArrayList<>();
        ArrayList<String> outputList = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            if(!words[i].equals("") && !words[i].contains(" ")) {
                wordsL.add(words[i]);
            }
        }



        boolean finish = false;
        for(int k = 0; k < wordsL.size(); k++) {
            wordsList.clear();
            outputList.clear();
            wordsList.addAll(wordsL);
            outputList.add(wordsList.get(k));
            wordsList.remove(k);
            int i = 0;
            int sizeList = 0;
            int sizeLastList = 0;
            while (wordsList.size() != 0) {
                sizeList = wordsList.size();
                String firstS = outputList.get(0).substring(0, 1);
                String lastS = outputList.get(outputList.size() - 1).substring(outputList.get(outputList.size() - 1).length() - 1);
                String firstL = wordsList.get(i).substring(0, 1);
                String lastL = wordsList.get(i).substring(wordsList.get(i).length() - 1);
                if (firstL.equalsIgnoreCase(lastS)) {
                    outputList.add(wordsList.get(i));
                    wordsList.remove(i);
                    if (i >= wordsList.size()) {
                        i = 0;
                    }
                    continue;
                }
                if (lastL.equalsIgnoreCase(firstS)) {
                    outputList.add(0, wordsList.get(i));
                    wordsList.remove(i);
                    if (i >= wordsList.size()) {
                        i = 0;
                    }
                    continue;
                }
                i++;
                if (i >= wordsList.size()) {
                    i = 0;
                    sizeLastList = wordsList.size();
                }
                if (sizeLastList == sizeList) {
                    break;
                }
            }
            if(wordsL.size() == outputList.size()) {
                break;
            }
        }

        for(int j = 0; j < outputList.size(); j++) {
            if(j != 0)
                output.append(" ");
            output.append(outputList.get(j));
        }

        return output;
    }
}
