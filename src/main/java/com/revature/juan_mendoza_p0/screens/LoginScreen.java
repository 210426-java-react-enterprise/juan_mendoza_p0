package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.exceptions.AuthenticationException;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.services.UserService;
import com.revature.juan_mendoza_p0.util.ScreenRouter;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    //only reader pointer to be used in this class, to be able
    //to take user credentials.
    private BufferedReader consoleReader;
    private UserDAO userDoa = new UserDAO();
    private ScreenRouter router;
    private UserService uService;


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
    public void render() {
        try {
            String username;
            String password;

            System.out.println("Login into your Sanctuary Bank!");
            System.out.println("+++++++++++++++++++++++++++++++++");

            System.out.println("Enter Username: ");
            System.out.print("> ");
            username = consoleReader.readLine();
            System.out.println("Enter Password: ");
            System.out.print("> ");
            password = consoleReader.readLine();

            AppUser validateUserInformation = uService.authenticate(username, password);
            if (validateUserInformation != null) {
                router.navigate("/account");
            }

        } catch (AuthenticationException e) {
            e.getMessage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
