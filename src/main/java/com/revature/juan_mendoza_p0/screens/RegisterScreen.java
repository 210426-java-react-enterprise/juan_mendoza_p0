package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.UserDOA;
import com.revature.juan_mendoza_p0.models.AppUsers;

import java.io.BufferedReader;
import java.io.IOException;

public class RegisterScreen {
    private UserDOA userDoa = new UserDOA();
    private BufferedReader consoleReader;

    public RegisterScreen(BufferedReader consoleReader){
        this.consoleReader = consoleReader;
    }
    public void Render(){
        String username;
        String password;
        String firstName;
        String lastName;
        String email;
        int age;

        try{
            System.out.println("Register for a new account!");
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");


            System.out.println("First Name: ");
            firstName = consoleReader.readLine();

            System.out.println("Last Name: ");
            lastName = consoleReader.readLine();

            System.out.println("Email: ");
            email = consoleReader.readLine();

            System.out.println("UserName: ");
            username = consoleReader.readLine();

            System.out.println("Password: ");
            password = consoleReader.readLine();

            System.out.println("Age: ");
            age = Integer.parseInt(consoleReader.readLine());


            AppUsers newUser = new AppUsers(username,password,firstName,lastName,email,age);
            userDoa.saveUserToFile(newUser);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
