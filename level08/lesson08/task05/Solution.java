package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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
        map.put("Сученька", "Иван");
        map.put("Юдич", "Рич");
        map.put("Хитрон", "Коля");
        map.put("Цимбалюк", "Светлана");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        String name = null;
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            name = pair.getValue();
            if(getCountTheSameFirstName(map, name) > 1) {
                System.out.println("!!!" + getCountTheSameFirstName(map, name) + " = " + name);
                removeItemFromMapByValue(map, name);
            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            if(pair.getValue().equals(value)) {
                iterator.remove();
            }
        }
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

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();            //ключ
            String value = pair.getValue();        //значение
            System.out.println(key + ":" + value);
        }
        System.out.println("==========================");
        removeTheFirstNameDuplicates(map);

        Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator();

        while (iterator2.hasNext()) {
            Map.Entry<String, String> pair = iterator2.next();
            String key = pair.getKey();            //ключ
            String value = pair.getValue();        //значение
            System.out.println(key + ":" + value);
        }
        System.out.println("==========================");
    }
}
