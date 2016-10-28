package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by riabov on 25.10.16.
 */
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public List<Advertisement> getActiveVideoSet() {
        List<Advertisement> list = new ArrayList<>();

        for (Advertisement ad: advertisementStorage.list()) {
            if(ad.getHits() > 0) {
                list.add(ad);
            }
        }

        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareToIgnoreCase(name2);
            }
        });

        return list;
    }

    public List<Advertisement> getArchivedVideoSet() {
        List<Advertisement> list = new ArrayList<>();

        for (Advertisement ad: advertisementStorage.list()) {
            if(ad.getHits() == 0) {
                list.add(ad);
            }
        }

        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareToIgnoreCase(name2);
            }
        });

        return list;
    }
}
