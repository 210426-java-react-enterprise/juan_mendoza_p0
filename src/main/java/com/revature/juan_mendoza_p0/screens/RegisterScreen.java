package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.services.UserService;
import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class RegisterScreen extends Screen {

    private UserService uService;
    private UserDAO userDoa = new UserDAO();
    private BufferedReader consoleReader;
    private ScreenRouter router;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router){
        super("RegisterScreen", "/register");
        this.consoleReader = consoleReader;
        this.router = router;
    }


    public void render(){
        String username;
        String password;
        String firstName;
        String lastName;
        String email;
        int age;

        try{
            System.out.println("Register for a new account!");
            System.out.println("++++++++++++++++++++++++++++++++++");


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


            AppUser newUser = new AppUser(username,password,firstName,lastName,email,age);

            uService.register(newUser);//Exception will be thrown if invalid input,null, or taken fields.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
