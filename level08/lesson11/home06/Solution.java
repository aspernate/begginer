package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> gen4 = new ArrayList<>();
        ArrayList<Human> gen3 = new ArrayList<>();
        gen3.add(new Human("ch1", true, 10, gen4));
        gen3.add(new Human("ch2", true, 11, gen4));
        gen3.add(new Human("ch3", true, 12, gen4));
        ArrayList<Human> gen21 = new ArrayList<>();
        gen21.add(new Human("F", true, 45, gen3));
        ArrayList<Human> gen22 = new ArrayList<>();
        gen22.add(new Human("M", false, 40, gen3));
        Human GF1 = new Human("GF1", true, 80, gen21);
        Human GF2 = new Human("GF2", true, 90, gen22);
        Human GM1 = new Human("GM1", false, 75, gen21);
        Human GM2 = new Human("GM2", false, 85, gen22);
        System.out.println(gen3.get(0));
        System.out.println(gen3.get(1));
        System.out.println(gen3.get(2));
        System.out.println(gen21.get(0));
        System.out.println(gen22.get(0));
        System.out.println(GF1);
        System.out.println(GF2);
        System.out.println(GM1);
        System.out.println(GM2);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
