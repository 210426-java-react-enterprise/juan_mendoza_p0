package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class WithdrawDepositScreen extends Screen{
    private ScreenRouter screenRouter;
    private BufferedReader consoleReader;

    public WithdrawDepositScreen(BufferedReader consoleReader, ScreenRouter screenRouter){
        super("Deposit/Withdraw","/wdScreen");
        this.consoleReader = consoleReader;
        this.screenRouter = screenRouter;
    }


    @Override
    public void render() {

    }
}
