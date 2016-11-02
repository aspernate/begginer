package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Tony Loner on 02.11.2016.
 */
public class HtmlView implements View
{
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies)
    {
        System.out.println(vacancies.size());
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
}
