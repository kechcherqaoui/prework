package com.enset;

import com.enset.model.BankAccount;
import com.enset.model.CurrentAccount;
import com.enset.model.SavingAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App1 {
    public static void main(String[] args) throws JsonProcessingException {
        BankAccount[] bankAccounts = new BankAccount[4];

        bankAccounts[0] = new CurrentAccount(18050,"MAD",82000);
        bankAccounts[1] = new SavingAccount(3000,"USD",4.2);
        bankAccounts[2] = new SavingAccount(4500,"MAD",1.8);
        bankAccounts[3] = new CurrentAccount(5000,"USD",52000);

        for (BankAccount b :bankAccounts) {
            b.print();
            System.out.println(b.getType());

            if (b instanceof CurrentAccount)
                System.out.println("overDraft = "+ ((CurrentAccount)b).getOverDraft());

            else if (b instanceof SavingAccount) {
                System.out.println("Rate = "+((SavingAccount)b).getInterestRate());
            }
        }

        System.out.println("--LIST--");
        List<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(new SavingAccount(450,"MAD",8.5));
        bankAccountList.add(new CurrentAccount(380,"MAD",4000));
        bankAccountList.add(new CurrentAccount(850,"MAD",5000));
        bankAccountList.add(new SavingAccount(900,"MAD",3.2));
        bankAccountList.add(new CurrentAccount(1010,"MAD",8000));

        for (BankAccount b: bankAccountList)
            System.out.println(b);

        System.out.println("--MAP--");
        Map<String, BankAccount> bankAccountMap = new HashMap<>();

        bankAccountMap.put("cc1", new CurrentAccount(222333,"MAD",4400));
        bankAccountMap.put("cc2", new SavingAccount(4972, "MAD",3.7));
        bankAccountMap.put("cc3", new CurrentAccount(322424, "MAD",6500));

        for (String key:bankAccountMap.keySet())
            System.out.println(bankAccountMap.get(key));

        for (BankAccount b:bankAccountMap.values())
            System.out.println(toJson(b));
    }

    public static String toJson(Object o) throws JsonProcessingException {
        return new ObjectMapper()
              .writerWithDefaultPrettyPrinter()
              .writeValueAsString(o);
    }
}
