package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.services.UserService;
import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class RegisterScreen extends Screen {

    private UserDAO userDoa = new UserDAO();
    private BufferedReader consoleReader;
    private ScreenRouter router;
    private final UserService userService;

    public RegisterScreen(BufferedReader consoleReader, ScreenRouter router, UserService userService){
        super("RegisterScreen", "/register");
        this.consoleReader = consoleReader;
        this.router = router;
        this.userService = userService;
    }


    public void render(){
        int age;

        try{
            System.out.println("Register for a new account!");
            System.out.println("++++++++++++++++++++++++++++++++++");


            System.out.println("First Name: ");
            String firstName = consoleReader.readLine();

            System.out.println("Last Name: ");
            String lastName = consoleReader.readLine();

            System.out.println("Email: ");
            String email = consoleReader.readLine();

            System.out.println("UserName: ");
            String username = consoleReader.readLine();

            System.out.println("Password: ");
            String password = consoleReader.readLine();

            System.out.println("Age: ");
            age = Integer.parseInt(consoleReader.readLine());


            AppUser newUser = new AppUser(username,password,firstName,lastName,email,age,0);

            userService.register(newUser);//Exception will be thrown if invalid input,null, or taken fields.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
