package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
        consoleReader.close();
        String str = "";
        while (fileReader.ready()){
            str = str + fileReader.readLine();
        }
        fileReader.close();

        Pattern pattern = Pattern.compile("(<" + args[0] + ")|(</" + args[0] + ">)");
        Matcher matcher = pattern.matcher(str);
        ArrayList<Integer> list = new ArrayList<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        while(matcher.find()){
            if(matcher.start(1) >= 0) {
                list.add(matcher.start(1));
                map.put(matcher.start(1), null);
            }
            if(matcher.end(2) >= 0) {
                map.put(list.get(list.size()-1), matcher.end(2));
                list.remove(list.size()-1);
            }
        }
        for(Map.Entry<Integer, Integer> p: map.entrySet()){
            System.out.println(str.substring(p.getKey(), p.getValue()));
        }

    }

}

