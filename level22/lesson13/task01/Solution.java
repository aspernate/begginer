package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static void main(String[] args) {
        String[] a = getTokens("level22.lesson13.task01", ".");
        for(String s: a) {
            System.out.println(s);
        }
    }

    public static String [] getTokens(String query, String delimiter) {
        if(query == "" || delimiter == "") {
            return new String[]{query};
        }
        ArrayList<String> array = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            array.add(token);
        }
        String[] arr = new String[array.size()];
        arr = array.toArray(arr);
        return arr;
    }
}
