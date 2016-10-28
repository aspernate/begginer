package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        Integer mediana = new Integer(0);
        if(array.length % 2 == 1) {
            mediana = array[array.length/2];
        }
        else{
            mediana = (array[array.length/2] + array[array.length/2-1])/2;
        }

        final Integer finalMediana = mediana;
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1- finalMediana) - Math.abs(o2- finalMediana);
            }
        });

        return array;
    }

    public static void main(String[] args) {
        Integer[] original1 = {11, 9, 3, 5, 5};
        Integer[] sorting = sort(original1);
        for(Integer i: sorting){
            System.out.print(i + " - ");
        }
        System.out.println();

        Integer[] original2 = {5, 1, 7, 3};
        sorting = sort(original2);
        for(Integer i: sorting){
            System.out.print(i + " - ");
        }
    }
}
