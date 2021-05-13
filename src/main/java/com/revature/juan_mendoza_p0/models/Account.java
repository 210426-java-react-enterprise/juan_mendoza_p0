package com.revature.juan_mendoza_p0.models;

public class Account {

    private int accountId;
    private double balance;
    private String accountType;

    public Account(){
        super();
    }

    public Account(double balance, String accountType){
        this.balance = balance;
        this.accountType = accountType;
    }

    public Account(int accountId, double balance, String accountType){
        this(balance,accountType);
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void withdrawMoney(double lessMoney){

        this.balance -= lessMoney;
    }

    public void depositMoney(double moreMoney){ balance += moreMoney; }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("Account: ");
        sb.append("ID= ").append(accountId).append('\'');
        sb.append("Account Type= ").append(accountType).append('\'');
        sb.append("Balance= ").append(balance);

        return sb.toString();

    }
}
