package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;

/**
 * Created by Tony Loner on 13.11.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new java.util.concurrent.ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for(Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Can't send message to " + pair.getKey());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    String name = message.getData();
                    if (name != null && !name.isEmpty() && !connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for(Map.Entry<String, Connection> pair: connectionMap.entrySet()) {
                if(!userName.equals(pair.getKey()))
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while(true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("This message is not TEXT");
                }
            }
        }

        public void run() {
            String errorMessage = "Error of connection";
            String userName = new String();
            try(Connection connection = new Connection(socket)) {
                SocketAddress socketAddress = connection.getRemoteSocketAddress();
                ConsoleHelper.writeMessage("Created connection to " + socketAddress);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(errorMessage);
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage(errorMessage);
            } finally {
                if(userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
            ConsoleHelper.writeMessage("Connection closed");
        }

    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter port:");
        int port = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server started");
            while(true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch (IOException e) {
            ConsoleHelper.writeMessage("Socket error");
        }
    }
}
