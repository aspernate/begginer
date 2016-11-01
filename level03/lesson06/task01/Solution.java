package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        String[] word = new String[3];
        word[0] = "Мама";
        word[1] = "Мыла";
        word[2] = "Раму";

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 3; k++)
                {
                    if(k != j && k != i && i != j)
                        System.out.println(word[i] + word[j] + word[k]);
                }
            }
        }

    }
}