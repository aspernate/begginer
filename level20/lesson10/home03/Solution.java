package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }

        public A(){}
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        public B(){
            super();
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(this.name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            this.name = (String)in.readObject();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        Solution.B bb = solution.new B("suka");
        System.out.println(bb.name);

        FileOutputStream fileOutputStream = new FileOutputStream("/tmp/1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bb);
        objectOutputStream.flush();
        objectOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("/tmp/1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Solution.B bbb = solution.new B("zalupa");
        System.out.println(bbb.name);
        bbb = (Solution.B)(objectInputStream.readObject());
        System.out.println(bbb.name);
    }
}
