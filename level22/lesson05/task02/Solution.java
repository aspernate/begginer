package com.javarush.test.level22.lesson05.task02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if(string == null){
            throw new TooShortStringException();
        }
        Pattern p = Pattern.compile("^[^\t]*\\t(.*)\\t[^\t]*$");
        Matcher m = p.matcher(string);
        if(!m.find()) {
            throw new TooShortStringException();
        }
        return m.group(1);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("A\tB\tC\tD\tE\tF\tG\tH\tI"));       //tab
        //System.out.println(getPartOfString("\t\t"));                    //
        //System.out.println(getPartOfString("123\t123"));                //Exception
        //System.out.println(getPartOfString(null));                      //Exception
    }
}


/*    public static String getPartOfString(String string) throws TooShortStringException{
        if(string == null){
            throw new TooShortStringException();
        }
        Pattern p = Pattern.compile("[^\t]*\\t([^\t]*)\\t");
        Matcher m = p.matcher(string);
        if(!m.find()) {
            throw new TooShortStringException();
        }
        return m.group(1);
    }*/
