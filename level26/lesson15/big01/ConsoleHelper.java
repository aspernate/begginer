package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by sony on 27.08.2016.
 */
public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = "";

        try {
            s = reader.readLine();
        } catch (IOException e) {

        }
        if(s.equalsIgnoreCase(res.getString("operation.EXIT")))
            throw new InterruptOperationException();
        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String code;

        writeMessage(res.getString("choose.currency.code"));

        while (true){
            code = readString();
            if(code.matches("\\w{3}")){
                break;
            }
            else
                writeMessage(res.getString("invalid.data"));
        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        String valueAndAmount;
        String[] result;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        while (true) {
            valueAndAmount = readString();
            if (valueAndAmount.matches("\\d+ \\d+")) {
                result = valueAndAmount.split(" ");
                if(result[0].equals("0") || result[1].equals("0")){
                    writeMessage(res.getString("invalid.data"));
                    continue;
                }
                return result;
            } else{
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage("1 - " + res.getString("operation.INFO"));
        writeMessage("2 - " + res.getString("operation.DEPOSIT"));
        writeMessage("3 - " + res.getString("operation.WITHDRAW"));

        while(true) {
            String line = readString();
            if(line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4"))
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage(res.getString("invalid.data"));
        }
    }
}
