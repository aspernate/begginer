package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<>();
        String line;
        Double max = 0.0;
        while((line = reader.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line, " ");
            String key = st.nextToken();
            Double value = Double.parseDouble(st.nextToken());

            if(map.containsKey(key)){
                map.put(key, map.get(key) + value);
            }
            else {
                map.put(key, value);
            }
            if(map.get(key) > max) {
                max = map.get(key);
            }
        }

        for(Map.Entry<String, Double> pair: map.entrySet()) {
            if(pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
        }
        reader.close();
    }
}
