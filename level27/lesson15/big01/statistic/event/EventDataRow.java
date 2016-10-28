package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by riabov on 24.10.16.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
