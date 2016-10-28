package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> family = new ArrayList<>();
        family.add(new Human("Genadiy", true, 79, null, null));
        family.add(new Human("Anatoliy", true, 77, null, null));
        family.add(new Human("Faya", false, 79, null, null));
        family.add(new Human("Valentina", false, 75, null, null));
        family.add(new Human("Vadim", true, 54, family.get(0), family.get(2)));
        family.add(new Human("Marina", false, 53, family.get(1), family.get(3)));
        family.add(new Human("Anton", true, 23, family.get(4), family.get(5)));
        family.add(new Human("Alexey", true, 29, family.get(4), family.get(5)));
        family.add(new Human("Maria", false, 22, family.get(4), family.get(5)));
        for(Human h: family) {
            System.out.println(h);
        }
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
