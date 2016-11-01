package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Tony Loner on 23.05.2016.
 */
public class RussianHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth(){
        return 7;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - " + RUSSIA +". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
