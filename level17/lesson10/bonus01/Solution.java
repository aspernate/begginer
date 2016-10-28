package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String param = null;
        try {
            param = reader.readLine();
        }
        catch (Exception e){}
        StringTokenizer st = new StringTokenizer(param, " ");
        ArrayList<String> list = new ArrayList<>();
        while(st.hasMoreElements()) {
            list.add(st.nextToken());
        }
        switch (list.get(0)){
            case "-c": {
                if(list.get(2).equals("м")){
                    try {
                        allPeople.add(Person.createMale(list.get(1), (new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)).parse(list.get(3))));
                    }
                    catch (Exception e){}
                }
                else{
                    try {
                        allPeople.add(Person.createFemale(list.get(1), (new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)).parse(list.get(3))));
                    }
                    catch (Exception e){}
                }
                System.out.println(allPeople.size()-1);
                break;
            }
            case  "-u": {
                allPeople.get(Integer.parseInt(list.get(1))).setName(list.get(2));
                if(list.get(3).equals("м"))
                    allPeople.get(Integer.parseInt(list.get(1))).setSex(Sex.MALE);
                else
                    allPeople.get(Integer.parseInt(list.get(1))).setSex(Sex.FEMALE);

                try {
                    allPeople.get(Integer.parseInt(list.get(1))).setBirthDay((new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)).parse(list.get(4)));
                } catch (ParseException e) {}
                break;
            }
        }


        /////
        for(Person p: allPeople){
            System.out.println(p.getName() + " " + p.getSex() + " " + p.getBirthDay());
        }
    }
}
