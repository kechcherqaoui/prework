package com.enset;

import com.enset.model.BankAccount;
import com.enset.model.CurrentAccount;
import com.enset.model.SavingAccount;

public class App {
    public static void main(String[] args) {
        BankAccount firstAccount = new CurrentAccount(8500,"MAD", 5200);
        BankAccount secondAccount = new SavingAccount(4200,"MAD", 2.3);
        BankAccount thirdAccount = firstAccount;

        System.out.println("-----------------------------------");
        secondAccount.setAccountId(firstAccount.getAccountId());
        System.out.println(firstAccount);
        System.out.println(secondAccount);
        System.out.println("-----------------------------------");
        System.out.println("using equals : " + firstAccount.equals(secondAccount));
        System.out.println("using == :" + (firstAccount == thirdAccount));
        System.out.println("-----------------------------------");
        System.out.println("HashCode  = "+ firstAccount.hashCode());
        System.out.println("HashCode  = "+ secondAccount.hashCode());
        System.out.println("-----------------------------------");

    }
    public static void printAccount(BankAccount bankAccount){
        System.out.println("-----------------------------------");
        System.out.println(bankAccount);
        System.out.println("-----------------------------------");
    }
}