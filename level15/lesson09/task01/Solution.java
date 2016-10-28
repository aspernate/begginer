package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.1, "a");
        labels.put(1.2, "b");
        labels.put(1.3, "c");
        labels.put(1.4, "d");
        labels.put(1.6, "e");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
