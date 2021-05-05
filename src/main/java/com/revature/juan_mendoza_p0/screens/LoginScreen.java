package com.revature.juan_mendoza_p0.screens;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginScreen {

    private BufferedReader consoleReader;

    public LoginScreen(BufferedReader consoleReader){
        this.consoleReader = consoleReader;
    }

    public void Render(){
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/user.txt"))){
            String userData = reader.readLine();

            String[] userSplitData = userData.split(";");
            String credentialUsername = userSplitData[0];
            String credentialPassword = userSplitData[1];

            System.out.println("Enter Username: ");
            String providedUsername = consoleReader.readLine();
            System.out.println("Enter Password: ");
            String providedPassword = consoleReader.readLine();

            if (providedUsername.equals(credentialUsername) && providedPassword.equals(credentialPassword)){
                System.out.println("Login Successful!");
            }else{
                System.out.println("Login Failed!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
