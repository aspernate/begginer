package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tony Loner on 02.11.2016.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath = "./src/"+this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException
    {
        Document document = getDocument();
        Element original = document.getElementsByClass("template").first();
        Element clone = original.clone();
        clone.removeClass("template").removeAttr("style");
        document.getElementsByAttributeValue("class", "vacancy").remove();

        for(Vacancy vacancy: vacancies) {
            Element vacElement = clone.clone();
            vacElement.getElementsByAttributeValue("class", "city").get(0).text(vacancy.getCity());
            vacElement.getElementsByAttributeValue("class", "companyName").get(0).text(vacancy.getCompanyName());
            vacElement.getElementsByAttributeValue("class", "salary").get(0).text(vacancy.getSalary());
            Element link = vacElement.getElementsByTag("a").get(0);
            link.text(vacancy.getTitle());
            link.attr("href", vacancy.getUrl());
            original.before(vacElement.outerHtml());
        }

        return document.html();
    }

    private void updateFile(String data) throws IOException
    {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(data);
        fileWriter.close();
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
