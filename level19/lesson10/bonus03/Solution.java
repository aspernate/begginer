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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader fileReader = new BufferedReader(new FileReader("/tmp/1.txt"));
        reader.close();
        String str = "";
        while (fileReader.ready()){
            str = str + fileReader.readLine();
        }
        //Pattern pattern = Pattern.compile("<tag.*>.*(<tag.*>.*</tag>)*.*</tag>");
        Pattern pattern = Pattern.compile("<tag");
        Matcher matcher = pattern.matcher(str);
        System.out.println("!" + str);
        int openCount = 0;
        int closeCount = 0;
        int startInd;
        int endInd;
        matcher.start();
    }
}
