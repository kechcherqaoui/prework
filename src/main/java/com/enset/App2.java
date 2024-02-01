package com.enset;

import com.enset.business.BankAccountService;
import com.enset.business.BankAccountServiceImpl;
import com.enset.exceptions.AccountNotFoundException;
import com.enset.model.BankAccount;
import com.enset.model.CurrentAccount;
import com.enset.model.SavingAccount;

import java.util.function.Consumer;

public class App2 {

    public static void main(String[] args) {

        BankAccountService bankAccountService = new BankAccountServiceImpl();
        
        bankAccountService.addAccount(
              new SavingAccount(4700,"MAD",2.5)
        );
        
        bankAccountService.addAccount(
              new CurrentAccount(7000,"MAD",4500)
        );

        CurrentAccount account = new CurrentAccount(5800, "MAD", 3200);

        account.setAccountId("CC1");

        bankAccountService.addAccount(account);

        //bankAccountService.getAllAccounts().forEach(System.out::println);
        bankAccountService.getAllAccounts().forEach(new Consumer<BankAccount>() {
            @Override
            public void accept(BankAccount bankAccount) {
                System.out.println(bankAccount);
            }
        });

        try {
            System.out.println(bankAccountService.getAccountById("CC3"));
        } catch (AccountNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---Suite du programme---");
    }

}
