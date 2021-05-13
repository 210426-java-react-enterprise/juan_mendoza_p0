package com.revature.juan_mendoza_p0.screens;

import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.exceptions.AuthenticationException;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.services.UserService;
import com.revature.juan_mendoza_p0.util.ScreenRouter;
import com.revature.juan_mendoza_p0.util.UserCache;

import java.io.BufferedReader;

public class LoginScreen extends Screen {

    //only reader pointer to be used in this class, to be able
    //to take user credentials.
    private BufferedReader consoleReader;
    private UserDAO userDoa = new UserDAO();
    private ScreenRouter router;
    private UserService uService;
    private UserCache userCache;


    /**
     * Constructer for loginscreen.
     * @param consoleReader
     */
    public LoginScreen(BufferedReader consoleReader, ScreenRouter router,
                       UserService uService,UserCache userCache){
        super("LoginScreen", "/login");
        this.consoleReader = consoleReader;
        this.router = router;
        this.userCache = userCache;
        this.uService = uService;
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
                userCache.setCurrentUserName(username);
                userCache.setCurrentPassword(password);
                router.navigate("/account");
            }

        } catch (AuthenticationException e) {
            e.getMessage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
