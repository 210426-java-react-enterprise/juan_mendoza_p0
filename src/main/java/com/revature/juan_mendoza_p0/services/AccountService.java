package com.revature.juan_mendoza_p0.services;

import com.revature.juan_mendoza_p0.doas.TransactionDAO;
import com.revature.juan_mendoza_p0.exceptions.InvalidInputException;
import com.revature.juan_mendoza_p0.exceptions.OverDraftInputException;


import java.text.DecimalFormat;

public class AccountService {
    private TransactionDAO transactionDao;

    public AccountService(TransactionDAO transactionDao){
        this.transactionDao = transactionDao;
    }

    public AccountService(){

    }

    public String formatDoubleToCurrency(double balance){
        DecimalFormat df = new DecimalFormat("#,###,###,###.00");
        return df.format(balance);

    }

    public boolean verifyInputGreaterZero(double checkAmount)throws InvalidInputException {
        if(checkAmount<0){
            throw new InvalidInputException("Amount provided is below zero!");
        }
        return true;
    }


    public boolean  isoverDraftingOccuring(String username , double amount)throws OverDraftInputException {
        double currentBalance = transactionDao.getCheckingBalance(username);
        double result = currentBalance - amount;
        if(result< 0){
            throw new OverDraftInputException("Overdrafting is not permitted!");
        }
        return false;
    }




}
