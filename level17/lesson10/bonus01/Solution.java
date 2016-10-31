package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        allPeople.add(Person.createMale("Иванов Иван", new Date())); //сегодня родился id=0
        allPeople.add(Person.createMale("Петров Петр", new Date())); //сегодня родился id=1
    }

    public static void main(String[] args) {

        switch (args[0]){
            case "-c": {create(args);break;}
            case "-u": {update(args);break;}
            case "-d": {delete(args);break;}
            case "-i": {info(args);break;}
        }


    }

    private static synchronized void create(String[] args) {
        if(args[2].equals("м")){
            try {
                allPeople.add(Person.createMale(args[1], (new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)).parse(args[3])));
            }
            catch (Exception e){}
        }
        else{
            try {
                allPeople.add(Person.createFemale(args[1], (new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)).parse(args[3])));
            }
            catch (Exception e){}
        }
        System.out.println(allPeople.size()-1);
    }

    private static synchronized void update(String[] args) {
        allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
        if(args[3].equals("м"))
            allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
        else
            allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);

        try {
            allPeople.get(Integer.parseInt(args[1])).setBirthDay((new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)).parse(args[4]));
        } catch (Exception e) {}
    }

    private static synchronized void delete(String[] args) {
        allPeople.remove(args[1]);
    }

    private static synchronized void info(String[] args) {
        if(allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE))
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " + "м" + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)).format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
        else
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " + "ж" + " " + (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)).format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
    }
}
