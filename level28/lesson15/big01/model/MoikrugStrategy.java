package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony Loner on 13.11.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36";
    private static final String referrer = "http://google.ru";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 1;

        try
        {
            while(true)
            {
                Document doc = getDocument(searchString, page++);
                Elements elements = doc.getElementsByClass("job");
                if (elements.size() == 0) break;

                for (Element element : elements)
                {
                    String title = element.getElementsByClass("title").first().text();


                    Element salaryElement = element.getElementsByClass("salary").first();
                    String salary = "";
                    if (salaryElement != null)
                    {
                        salary = salaryElement.text();
                    }

                    Element cityElement =  element.getElementsByClass("location").first();
                    String city = "";
                    if(cityElement != null)
                        city = cityElement.text();

                    String companyName = element.getElementsByClass("company_name").first().getElementsByAttribute("href").first().text();

                    String siteName = "https://moikrug.ru/";

                    String url = siteName.substring(0, siteName.length()-1) + element.getElementsByClass("title").first().getElementsByAttribute("href").attr("href");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);
                }
            }
        }
        catch (IOException e){}

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, page, searchString);
        //return Jsoup.connect("http://javarush.ru/testdata/big28data2.html").get();
        return Jsoup.connect(url)
                .userAgent(userAgent)
                .referrer(referrer)
                .get();
    }
}
