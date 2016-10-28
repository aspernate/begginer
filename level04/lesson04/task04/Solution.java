package com.javarush.test.level04.lesson04.task04;

/* Время года
Реализовать метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.
Пример для номера месяца 2:
зима
Пример для номера месяца 5:
весна
*/

public class Solution
{
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int mount){
        String mount_s;
        switch (mount) {
            case 1: mount_s = "зима"; break;
            case 2: mount_s = "зима"; break;
            case 3: mount_s = "весна"; break;
            case 4: mount_s = "весна"; break;
            case 5: mount_s = "весна"; break;
            case 6: mount_s = "лето"; break;
            case 7: mount_s = "лето"; break;
            case 8: mount_s = "лето"; break;
            case 9: mount_s = "осень"; break;
            case 10: mount_s = "осень"; break;
            case 11: mount_s = "осень"; break;
            case 12: mount_s = "зима"; break;
            default: mount_s = "не правильный месяц"; break;
        }
        System.out.println(mount_s);
    }
}