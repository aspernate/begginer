package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Tony Loner on 13.11.2016.
 */
public class Connection extends Socket
{
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException
    {
        this.socket = socket;
        out = (ObjectOutputStream) socket.getOutputStream();
        in = (ObjectInputStream) socket.getInputStream();
    }

    public void send(Message message) throws IOException {

    }
}
