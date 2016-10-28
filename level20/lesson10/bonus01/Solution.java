package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args){
        long a=System.currentTimeMillis();
        int[] y = getNumbers(1000);
        long b=System.currentTimeMillis();
        System.out.println("time seconds "+(b-a)/1000);
        System.out.println("memory "+(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory())/1024/1024 + " mb");
    }

    public static int[] getNumbers(int N) {
        int[] result = null;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < N; i++) {
            int degree = getDegree(i);
            for (int j = degree; j <= getDegree(N); j++) {
                int sum = 0;
                int input = i;
                int now = 0;
                int last = 0;
                boolean stop = false;
                do {
                    now = input % 10;
                    if (last < now && last != 0 || now == 0) {
                        stop = true;
                        break;
                    }
                    sum = sum + (int) Math.pow(now, j);
                    last = now;

                } while ((input /= 10) > 0);

                if (stop) continue;
                if(getDegree(sum) > getDegree(N))
                    break;

               // System.out.println(i + " " + sum);

                input = sum;
                int new_sum=0;
                do {
                    now = input % 10;
                    new_sum = new_sum + (int) Math.pow(now, getDegree(sum));
                } while ((input /= 10) > 0);
                if(sum == new_sum){
                    System.out.println(i + " " + sum);
                }


                //System.out.println(i);

            }
        }

        return result;
    }

    public static int getDegree(int i) {
        int degree = 0;

        do {
            degree += 1;
        } while ( (i /= 10) > 0);

        return degree;
    }
}
