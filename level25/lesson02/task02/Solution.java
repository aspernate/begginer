package com.javarush.test.level25.lesson02.task02;

import java.util.*;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            ArrayList<Wheel> temp = new ArrayList<>();
            boolean bad = false;
            wheels = new ArrayList<>();
            String[] array = loadWheelNamesFromDB();
            if(array.length != 4)
                return;
            for(int i = 0; i < array.length; i++) {
                try {
                    temp.add(Wheel.valueOf(array[i]));
                }
                catch (IllegalArgumentException e) {
                    bad = true;
                }
            }
            if(bad)
                return;
            wheels = temp;
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
