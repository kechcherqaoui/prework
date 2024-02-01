package com.enset;

import com.enset.business.BankAccountService;
import com.enset.business.BankAccountServiceImpl;
import com.enset.business.Condition;
import com.enset.exceptions.AccountNotFoundException;
import com.enset.exceptions.BalanceNotSufficientException;
import com.enset.model.AccountStatus;
import com.enset.model.BankAccount;
import com.enset.model.CurrentAccount;
import com.enset.utils.DataTransformationUtils;

import java.util.List;

public class App3 {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addRandomData(12);

        BankAccount bankAccount1 = new CurrentAccount(9500,"MAD",5200);
        bankAccount1.setAccountId("CC1");

        BankAccount bankAccount2 = new CurrentAccount(7500,"MAD",3200);
        bankAccount2.setAccountId("CC2");

        bankAccountService.addAccount(bankAccount2);
        bankAccountService.addAccount(bankAccount1);

       /* bankAccountService.getAllAccounts()
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);*/
        
        BankAccount accountCC1 = null;
        BankAccount accountCC2 = null;
        
        try {
            accountCC1 = bankAccountService.getAccountById("CC1");
            accountCC2 = bankAccountService.getAccountById("CC2");

            System.out.println("--------------------------------");
            System.out.println(accountCC1.getAccountId() + " " + accountCC1.getBalance());

            System.out.println("---Credit---");
            bankAccountService.credit(accountCC1.getAccountId(), 7000);
            System.out.println(accountCC1.getAccountId() + " " + accountCC1.getBalance());

            System.out.println("---Debit---");
            bankAccountService.debit(accountCC1.getAccountId(), 5000);
            System.out.println(accountCC1.getAccountId() + " " + accountCC1.getBalance());

            System.out.println("---Before transfer---");
            System.out.println(accountCC1.getAccountId() + " " + accountCC1.getBalance());
            System.out.println(accountCC2.getAccountId() + " " + accountCC2.getBalance());

            System.out.println("---After transfer---");
            bankAccountService.transfer("CC1","CC2", 9000);
            System.out.println(accountCC1.getAccountId() + " " + accountCC1.getBalance());
            System.out.println(accountCC2.getAccountId() + " " + accountCC2.getBalance());
            System.out.println("--------------------------------");

        } catch (BalanceNotSufficientException | AccountNotFoundException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println("---Followed program---");
        System.out.println(accountCC1.getAccountId() + " " + accountCC1.getBalance());
        System.out.println(accountCC2.getAccountId() + " " + accountCC2.getBalance());

        System.out.println("---CurrentAccount---");
        bankAccountService
              .getAllCurrentAccounts()
              .forEach(System.out::println);

        System.out.println("---SavingAccount---");
        bankAccountService
              .getAllSavingAccounts()
              .forEach(System.out::println);

        System.out.println("---TotalBalance---");
        System.out.println(bankAccountService.getTotalBalances());

        System.out.println("---Condition test---");
        List<BankAccount> bankAccounts = bankAccountService
              .searchBankAccount(new Condition<BankAccount>() {
            @Override
            public boolean test(BankAccount bankAccount) {
                return bankAccount.getStatus().equals(AccountStatus.ACTIVATED);
            }
        });

        bankAccounts.stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);

    }

}
