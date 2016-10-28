package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count;
        count = getRectangleCountOptimization(a);
        System.out.println("count = " + count + ". Должно быть 2");
        a = new byte[][] {
                {0,1,1,0,0,0,0,0,1},
                {0,1,1,0,1,1,1,0,1},
                {0,0,0,0,1,1,1,0,0},
                {1,1,1,0,1,1,1,0,1},
                {1,1,1,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,0,1,1,0},
                {0,1,1,1,1,0,1,1,0},
                {0,0,0,0,0,0,1,1,0},

        };
        count = getRectangleCountOptimization(a);
        System.out.println("count = " + count + ". Должно быть 7");
    }

    public static int getRectangleCountOptimization(byte[][] a) {
        int count = 0;
        int i, j;
        for(i = 0; i < a.length; i++) {
            for(j = 0; j < a.length; j++) {
                if(a[i][j] == 1 && (i == 0 && j == 0 || i == 0 && j != 0 && a[i][j-1] == 0 || j == 0 && i != 0 && a[i-1][j] == 0 || i != 0 && j != 0 && a[i-1][j] == 0 && a[i][j-1] == 0)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] mass = a;

        int count = 0;

        int is;
        int js;
        int ie;
        int je;

        int i;
        int j;

        for(i = 0; i < mass.length; i++) {
            for(j = 0; j < mass.length; j++) {
                if(a[i][j] == 1) {
                    is = i;
                    js = j;
                    ie = findIe(mass, is, js);
                    je = findJe(mass, is, js);
                    count++;
                    mass = cleanRectangle(mass, is, js, ie, je);
                }
            }
        }

        return count;
    }

    public static int findJe(byte[][] a, int is, int js) {
        int j;
        for(j = js; j < a.length; j++) {
            if(a[is][j] == 0 || j == a.length-1) {
                return j;
            }

        }
        return  0;
    }

    public static int findIe(byte[][] a, int is, int js) {
        int i;
        for(i = is; i < a.length; i++) {
            if(a[i][js] == 0 || i == a.length-1) {
                return i;
            }
        }
        return  0;
    }

    public static byte[][] cleanRectangle(byte[][] a, int is, int js, int ie, int je) {
        byte[][] mass = a;
        int i, j;
        for(i = is; i <= ie; i++) {
            for (j = js; j <= je; j++) {
                mass[i][j] = 0;
            }
        }
        return  mass;
    }
}
