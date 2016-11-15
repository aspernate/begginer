package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by riabov on 15.11.16.
 */
public class BotClient extends Client{

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] msg = message.split(": ");
            String userName = msg[0];
            String command = msg[1];

            super.processIncomingMessage(message);
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    private static int lastCreatedBotId = -1;
    @Override
    protected String getUserName() {
        if (lastCreatedBotId == 99) lastCreatedBotId = 0;
        else lastCreatedBotId++;
        return "date_bot_" + lastCreatedBotId;

    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
