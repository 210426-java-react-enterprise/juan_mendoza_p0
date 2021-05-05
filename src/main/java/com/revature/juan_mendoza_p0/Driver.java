package com.revature.juan_mendoza_p0;

import com.revature.juan_mendoza_p0.screens.LoginScreen;
import com.revature.juan_mendoza_p0.screens.RegisterScreen;

import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        System.out.println("Inside");

        System.out.println("Welcome to Sanctuary Banking!");
        System.out.println("1) Register \n 2) Login");

        int selectionUser = 0;
        Scanner selScan = new Scanner(System.in);
        selectionUser = selScan.nextInt();

        if (selectionUser == 1){
            try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))){
                RegisterScreen registerScreen = new RegisterScreen((consoleReader));
                registerScreen.render();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if (selectionUser == 2){
            try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))){
                LoginScreen loginScreen = new LoginScreen(consoleReader);
                loginScreen.render();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Please choose again.");
            selectionUser = selScan.nextInt();
        }
    }
}
