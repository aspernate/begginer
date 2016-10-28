package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();;
    public String getCurrencyCode()
    {
        return currencyCode;
    }
    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else
        {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int sum = 0;
        for(Map.Entry<Integer, Integer> pair: denominations.entrySet()) {
            sum = sum + pair.getKey()*pair.getValue();
        }
        return sum;
    }

    public boolean hasMoney() {
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return (expectedAmount <= getTotalAmount());
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> denominationsSort = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o2).compareTo((Integer) o1);
            }
        });
        denominationsSort.putAll(denominations);

        Map<Integer, Integer> map = new HashMap<>();


        while(true) {
            int amount = expectedAmount;
            int outAmount = 0;
            for (Map.Entry<Integer, Integer> pair : denominationsSort.entrySet()) {
                int denomination = pair.getKey();
                int count = pair.getValue();
                int outCount = amount / denomination;
                if (outCount == 0)
                    continue;
                if (outCount > count)
                    outCount = count;
                map.put(denomination, outCount);
                amount = amount - denomination * outCount;
                outAmount = outAmount + denomination * outCount;
            }
            if (outAmount != expectedAmount) {
                denominationsSort.remove(denominationsSort.entrySet().iterator().next().getKey());
                if(!denominationsSort.entrySet().iterator().hasNext()) {
                    throw new NotEnoughMoneyException();
                }
                map.clear();
            }
            else
            {
                break;
            }
        }

        for(Map.Entry<Integer, Integer> pair: map.entrySet()) {
            if(pair.getValue() == denominations.get(pair.getKey())){
                denominations.remove(pair.getKey());
            }
            else {
                denominations.put(pair.getKey(), denominations.get(pair.getKey()) - pair.getValue());
            }
        }


        return map;
    }
}
