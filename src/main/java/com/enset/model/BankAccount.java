package com.enset.model;

import java.util.Objects;
import java.util.UUID;

public abstract class BankAccount {
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public BankAccount() {
        this.accountId = UUID.randomUUID().toString();
        this.status = AccountStatus.CREATED;
    }

    public BankAccount(double balance, String currency) {
        this();
        this.balance = balance;
        this.currency = currency;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object account) {

        BankAccount bankAccount = (BankAccount) account;
        return this.balance == bankAccount.balance &&
                this.currency.equals(bankAccount.currency) &&
                this.accountId.equals(bankAccount.accountId) &&
                this.status == bankAccount.status;
    }

    @Override
    public int hashCode() {
        return 31 * (Objects.hashCode(accountId) +
                Objects.hashCode(balance) +
                Objects.hashCode(status) +
                Objects.hashCode(currency));
    }

    public abstract String getType();

    public final void print(){
        System.out.println("----WEST-BANK----");
    }

    @Override
    public String toString() {
        return "BankAccount{" +
              "accountId='" + accountId + '\'' +
              ", balance=" + balance +
              ", currency='" + currency + '\'' +
              ", status=" + status +
              '}';
    }
}
