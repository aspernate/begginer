package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by riabov on 31.10.16.
 */
public class Aggregator {
    public static void main(String[] args) {
        Provider[] providers = new Provider[]{new Provider(new HHStrategy()), new Provider(new MoikrugStrategy())};
        HtmlView view = new HtmlView();
        Model model = new Model(view, providers);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
