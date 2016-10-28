package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = "";
        try {
            url = reader.readLine();
        }
        catch (Exception e) {}
        url = "javarush.ru/alpha/index.html?lvl=15&??view&&&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&&?oobj=3.0";
        ArrayList<Integer> list = new ArrayList<>();
        char[] arr = url.toCharArray();
        for(int i = url.indexOf('?'); i < url.length(); i++) {
            if(arr[i] == '?' || arr[i] == '&') {
                list.add(i);
            }
        }
        list.add(arr.length);
        ArrayList<String> params = new ArrayList<>();
        for(int i = 0; i < list.size()-1; i++) {
            params.add(url.substring(list.get(i)+1, list.get(i+1)));
        }

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for(String s: params) {
            if (s.contains("=")) {
                map.put(s.substring(0, s.indexOf('=')), s.substring(s.indexOf('=')+1, s.length()));
            }
            else {
                map.put(s, "");
            }
        }

        Iterator<Map.Entry<String, String>> itr1 = map.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry<String, String> entry = itr1.next();
            System.out.print(entry.getKey());
            if(itr1.hasNext())
                System.out.print(" ");
        }

        System.out.println("");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(entry.getKey().equals("obj")) {
                if(entry.getValue().contains(".")) {
                    alert(Double.parseDouble(entry.getValue()));
                }
                else {
                    alert(entry.getValue());
                }
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
