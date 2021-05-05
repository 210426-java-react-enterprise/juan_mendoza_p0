package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.UserDOA;
import com.revature.juan_mendoza_p0.models.AppUser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class LoginScreen extends Screen {

    //only reader pointer to be used in this class, to be able
    //to take user credentials.
    private BufferedReader consoleReader;
    private UserDOA userDoa = new UserDOA();


    /**
     * Constructer for loginscreen.
     * @param consoleReader
     */
    public LoginScreen(BufferedReader consoleReader){
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
    }

    /**
     * Method to get user credential, and verify user credential using UserDOA class.
     */
    public void render(){
        try{
            String username;
            String password;

            System.out.println("Login into your Sanctuary Bank!");
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

            System.out.println("Enter Username: ");
            System.out.println(">");
            username = consoleReader.readLine();
            System.out.println("Enter Password: ");
            System.out.println(">");
            password = consoleReader.readLine();


            //make sure nothing empty was given
            if(username != null && !username.isEmpty() && password != null & password.isEmpty()){
                AppUser authenticatedUser = userDoa.findUserByUsernameAndPassword(username,password);
                if(authenticatedUser != null){
                    System.out.println("Login successful!");
                }else{
                    System.out.println("Login failed!");
                }
            }else{
                System.out.println("Did not provide credentials.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
