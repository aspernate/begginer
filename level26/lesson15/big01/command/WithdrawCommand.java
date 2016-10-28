package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * Created by riabov on 13.10.16.
 */
class WithdrawCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException{
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String valueStr;
        while(true) {
            ConsoleHelper.writeMessage(res.getString("before"));
            valueStr = ConsoleHelper.readString();
            if (valueStr.matches("\\d+")) {
                if (currencyManipulator.isAmountAvailable(Integer.parseInt(valueStr))) {
                }//break;
                else {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }
            } else {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                continue;
            }

            int amount = Integer.parseInt(valueStr);

            try {
                Map<Integer, Integer> map = currencyManipulator.withdrawAmount(amount);
                Map<Integer, Integer> mapSort = new TreeMap<>(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return ((Integer) o2).compareTo((Integer) o1);
                    }
                });
                mapSort.putAll(map);
                for (Map.Entry<Integer, Integer> pair : mapSort.entrySet()) {
                    ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                break;
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
        }
    }
}
