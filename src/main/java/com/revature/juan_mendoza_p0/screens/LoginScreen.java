package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    //only reader pointer to be used in this class, to be able
    //to take user credentials.
    private BufferedReader consoleReader;
    private UserDAO userDoa = new UserDAO();
    private ScreenRouter router;


    /**
     * Constructer for loginscreen.
     * @param consoleReader
     */
    public LoginScreen(BufferedReader consoleReader, ScreenRouter router){
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
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
            System.out.print("> ");
            username = consoleReader.readLine();
            System.out.println("Enter Password: ");
            System.out.print("> ");
            password = consoleReader.readLine();


            //make sure nothing empty was given
            if(username != null && !username.isEmpty() && password != null && !password.isEmpty()){
                AppUser authenticatedUser = userDoa.findUserByUsernameAndPassword(username,password);

                if(authenticatedUser != null){
                    System.out.println("Login successful!");
                }else{
                    System.out.println("Login failed!");
                }
            }else{
                System.out.println("Did not provide credentials.");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
