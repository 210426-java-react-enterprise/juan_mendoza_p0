package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class WelcomeScreen extends Screen {

    //only  buffered reader to be used for getting user input
    private BufferedReader consoleReader;
    private ScreenRouter router;

    //dependency injection (dependent on: BufferedReader & ScreenRouter)
    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router){
        super("WelcomeScreen","/welcome");
        this.consoleReader = consoleReader;
        this.router = router;
    }

    @Override
    public void render(){
    System.out.println("Sanctuary Banking");
    System.out.println("1) Login");
    System.out.println("2) Register");
    System.out.println("3)Exit application");
    System.out.print("> ");
        try {
            String userOption = consoleReader.readLine();

            switch (userOption) {
                case "1":
                    System.out.println("Navigating to login screen");
                    router.navigate("/login");
                    break;
                case "2":
                    System.out.println("Navigating to register screen");
                    router.navigate("/register");
                    break;
                case "3":
                    System.out.println("Now leaving application.Goodbye.");
                    break;
                default:
                    System.out.println("Invalid Selection!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
