package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException{
        System.out.println(getPartOfString(" 1 1 1 1 1 1"));
    }

    public static String getPartOfString(String string) throws TooShortStringException{
        String result;
        try {
            String [] m =string.split(" ");
            result = m[1] + " " + m[2] + " " + m[3] + " " + m[4];
        }
        catch (Exception e){
            throw new TooShortStringException();
        }
        return result;

    }

    public static class TooShortStringException extends Exception{
    }
}
