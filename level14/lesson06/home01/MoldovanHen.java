package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Tony Loner on 23.05.2016.
 */
public class MoldovanHen extends Hen implements Country
{
    public int getCountOfEggsPerMonth(){
        return 6;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - " + MOLDOVA +". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
