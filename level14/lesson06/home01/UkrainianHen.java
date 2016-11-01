package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Tony Loner on 23.05.2016.
 */
public class UkrainianHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth(){
        return 6;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - " + UKRAINE +". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
