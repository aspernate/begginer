package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Galone", new Date("JANUARY 2 1980"));
        map.put("Felone", new Date("FEBRUARY 3 1980"));
        map.put("Alone", new Date("MARCH 4 1980"));
        map.put("Molone", new Date("APRIL 5 1980"));
        map.put("Werone", new Date("MAY 6 1980"));
        map.put("Kijole", new Date("SEPTEMBER 7 1980"));
        map.put("Qweroly", new Date("JULY 8 1980"));
        map.put("Zenity", new Date("AUGUST 9 1980"));
        map.put("Miraly", new Date("OCTOBER 10 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            if(pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7) {
                iterator.remove();
            }
        }

    }

}
