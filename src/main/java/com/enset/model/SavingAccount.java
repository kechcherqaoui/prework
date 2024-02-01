package com.enset.model;

public final class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount(){
        super();
    }

    public SavingAccount(double balance, String currency, double interestRate){
        super(balance, currency);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "SavingAccount { interestRate = "+ this.interestRate+" "+super.toString();
    }

    @Override
    public String getType() {
        return "SavingAccount";
    }
}
