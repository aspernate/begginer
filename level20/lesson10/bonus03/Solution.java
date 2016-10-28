package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same", "nar");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        int M = crossword.length;
        int N = crossword[0].length;

        for(String word_s: words) {
            char[] word = word_s.toCharArray();
            int k = 0;
            int ii = 0;
            int jj = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (crossword[i][j] == word[0]) {
                    // ->
                        k = 0;
                        ii = i;
                        jj = j;
                        while (jj < N - 1 && k < word.length - 1 && crossword[ii][jj + 1] == word[k + 1]) {
                            jj += 1;
                            k += 1;
                        }
                        if (k == word.length - 1) {
                            list.add(new Word(word_s));
                            list.get(list.size()-1).setStartPoint(j, i);
                            list.get(list.size()-1).setEndPoint(jj, ii);
                        }

                    // |,
                        k = 0;
                        ii = i;
                        jj = j;
                        while (ii < M - 1 && k < word.length - 1 && crossword[ii + 1][jj] == word[k + 1]) {
                            ii += 1;
                            k += 1;
                        }
                        if (k == word.length - 1 && word.length != 1) {
                            list.add(new Word(word_s));
                            list.get(list.size()-1).setStartPoint(j, i);
                            list.get(list.size()-1).setEndPoint(jj, ii);
                        }
                    // <-
                        k = 0;
                        ii = i;
                        jj = j;
                        while (jj > 0 && k < word.length - 1 && crossword[ii][jj-1] == word[k + 1]) {
                            jj -= 1;
                            k += 1;
                        }
                        if (k == word.length - 1 && word.length != 1) {
                            list.add(new Word(word_s));
                            list.get(list.size()-1).setStartPoint(j, i);
                            list.get(list.size()-1).setEndPoint(jj, ii);
                        }
                    // |'
                        k = 0;
                        ii = i;
                        jj = j;
                        while (ii > 0 && k < word.length - 1 && crossword[ii-1][jj] == word[k + 1]) {
                            ii -= 1;
                            k += 1;
                        }
                        if (k == word.length - 1 && word.length != 1) {
                            list.add(new Word(word_s));
                            list.get(list.size()-1).setStartPoint(j, i);
                            list.get(list.size()-1).setEndPoint(jj, ii);
                        }
                    // \,
                        k = 0;
                        ii = i;
                        jj = j;
                        while (ii < M -1 && jj < N -1 && k < word.length - 1 && crossword[ii+1][jj+1] == word[k + 1]) {
                            ii += 1;
                            jj += 1;
                            k += 1;
                        }
                        if (k == word.length - 1 && word.length != 1) {
                            list.add(new Word(word_s));
                            list.get(list.size()-1).setStartPoint(j, i);
                            list.get(list.size()-1).setEndPoint(jj, ii);
                        }
                    // ,/
                        k = 0;
                        ii = i;
                        jj = j;
                        while (ii < M -1 && jj > 0 && k < word.length - 1 && crossword[ii+1][jj-1] == word[k + 1]) {
                            ii += 1;
                            jj -= 1;
                            k += 1;
                        }
                        if (k == word.length - 1 && word.length != 1) {
                            list.add(new Word(word_s));
                            list.get(list.size()-1).setStartPoint(j, i);
                            list.get(list.size()-1).setEndPoint(jj, ii);
                        }
                    // '\
                        k = 0;
                        ii = i;
                        jj = j;
                        while (ii > 0 && jj > 0 && k < word.length - 1 && crossword[ii-1][jj-1] == word[k + 1]) {
                            ii -= 1;
                            jj -= 1;
                            k += 1;
                        }
                        if (k == word.length - 1 && word.length != 1) {
                            list.add(new Word(word_s));
                            list.get(list.size()-1).setStartPoint(j, i);
                            list.get(list.size()-1).setEndPoint(jj, ii);
                        }
                    // /'
                        k = 0;
                        ii = i;
                        jj = j;
                        while (ii > 0 && jj <  N -1 && k < word.length - 1 && crossword[ii-1][jj+1] == word[k + 1]) {
                            ii -= 1;
                            jj += 1;
                            k += 1;
                        }
                        if (k == word.length - 1 && word.length != 1) {
                            list.add(new Word(word_s));
                            list.get(list.size()-1).setStartPoint(j, i);
                            list.get(list.size()-1).setEndPoint(jj, ii);
                        }
                    }


                }
            }
        }
        return list;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}