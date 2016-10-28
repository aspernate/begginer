package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.channels.Pipe;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        while((line = reader.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line, " ");
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreElements()){
                list.add(st.nextToken());
            }
            Date birthday = new GregorianCalendar(Integer.parseInt(list.get(list.size()-1)), Integer.parseInt(list.get(list.size()-2))-1, Integer.parseInt(list.get(list.size()-3))).getTime();
            String name = "";
            for(int i = 0; i < list.size()-3; i++){
                if(i != list.size()-4)
                    name = name + list.get(i) + " ";
                else
                    name = name + list.get(i);
            }
            PEOPLE.add(new Person(name, birthday));
        }
        reader.close();

    }

}
