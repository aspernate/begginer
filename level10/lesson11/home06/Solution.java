package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        boolean sex;
        String born;
        int weight;
        int height;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, String born) {
            this.name = name;
            this.born = born;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, boolean sex, String born) {
            this.name = name;
            this.sex = sex;
            this.born = born;
        }

        public Human(String name, int weight, int height){
            this.name = name;
            this.weight = weight;
            this.height = height;
        }

        public Human(int age, int weight, int height){
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(boolean sex, int weight, int height){
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        public Human(int weight, int height){
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

    }
}
