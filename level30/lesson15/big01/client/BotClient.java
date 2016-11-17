package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
            if(!message.contains(": "))
                return;
            String[] msg = message.split(": ");
            String userName = msg[0];
            String command = msg[1];
            SimpleDateFormat dateFormat = null;
            switch (command) {
                case "дата": dateFormat = new SimpleDateFormat("d.MM.YYYY");
                    break;
                case "день": dateFormat = new SimpleDateFormat("d");
                    break;
                case "месяц": dateFormat = new SimpleDateFormat("MMMM");
                    break;
                case "год": dateFormat = new SimpleDateFormat("YYYY");
                    break;
                case "время": dateFormat = new SimpleDateFormat("H:mm:ss");
                    break;
                case "час": dateFormat = new SimpleDateFormat("H");
                    break;
                case "минуты": dateFormat = new SimpleDateFormat("m");
                    break;
                case "секунды": dateFormat = new SimpleDateFormat("s");
                    break;
                default: return;
            }
            Calendar calendar = new GregorianCalendar();
            String newMessage = "Информация для " + userName + ": " + dateFormat.format(calendar.getTime());
            if(dateFormat != null) {
                sendTextMessage(newMessage);
            }
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
