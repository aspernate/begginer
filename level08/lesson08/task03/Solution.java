package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("Агафонов", "Ирина");
        map.put("Хуец", "Слава");
        map.put("Какуев", "Ирина");
        map.put("Улюмжуев", "Иван");
        map.put("Сачко", "Рита");
        map.put("Ебалко", "Костя");
        map.put("Сученька", "Дима");
        map.put("Юдич", "Рич");
        map.put("Хитрон", "Коля");
        map.put("Цимбалюк", "Светлана");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int i = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if(pair.getValue().equals(name)) {
                i++;
            }
        }
        return i;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int i = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if(pair.getKey().equals(lastName)) {
                i++;
            }
        }
        return i;

    }
}
