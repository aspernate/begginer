package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

/**
 * Created by Tony Loner on 13.11.2016.
 */
public class Message implements Serializable
{
    private final MessageType type;
    private final String data;

    public MessageType getType()
    {
        return type;
    }

    public String getData()
    {
        return data;
    }

    public Message(MessageType type)
    {
        this.type = type;
        this.data = null;
    }

    public Message(MessageType type, String data)
    {
        this.data = data;
        this.type = type;
    }
}
