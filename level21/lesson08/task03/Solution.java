package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public Object clone() throws CloneNotSupportedException {
            return  new C(this.getI(), this.getJ(), this.getName());
        }
    }

    public static void main(String[] args) throws Exception{
        A a = new A(1, 2);
        B b = new B(1,2,"3");
        C c = new C(4,5,"6");

        A cloneA = (A) a.clone();
        System.out.println(a);
        System.out.println(cloneA);
        System.out.println(a.getI() + " " + a.getJ());
        System.out.println(cloneA.getI() + " " + cloneA.getJ());

        C cloneC = (C) c.clone();
        System.out.println(c);
        System.out.println(cloneC);
        System.out.println(c.getI() + " " + c.getJ() + " " + c.getName());
        System.out.println(cloneC.getI() + " " + cloneC.getJ() + " " + cloneC.getName());
    }
}
