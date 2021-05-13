package com.revature.juan_mendoza_p0.services;

import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.exceptions.InvalidRequestException;
import com.revature.juan_mendoza_p0.exceptions.ResourcePersistenceException;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.util.ConnectionFactory;

import javax.naming.AuthenticationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    //dependency injection, now dependent on the class userDAO
    private UserDAO userDao;

    public UserService(UserDAO userDao){

        this.userDao = userDao;
    }
    public UserService(){

    }


    /**
     * Method to check user input whether valid, taken names on fields that are unique such as username or email
     *
     * @param newUser   An AppUser to be tested.
     * @return          The AppUser has been validated and saved to the DataBase.
     * @throws InvalidRequestException
     * @throws ResourcePersistenceException
     */


    public void register(AppUser newUser) throws InvalidRequestException, ResourcePersistenceException {
        if(!isUserValid(newUser)){
            throw new InvalidRequestException("Invalid new user data provided!");
        }
        if(!isUserNameAvailable(newUser.getUsername())){
            throw new ResourcePersistenceException("The provided username is not unique!");
        }
        if(!isEmailAvailalbe(newUser.getEmail())){
            throw new ResourcePersistenceException("The provided email is taken!");
        }

        userDao.save(newUser);
    }

    /**
     * Method for verifying user input, no blank entries, length will be checked depeding on the field.
     * We also check for null values.
     * @param user  Appuser with fields (username, password, firstname, lastname, email, age)
     * @return      boolean value whether provided input is valid.
     */
    public boolean isUserValid(AppUser user){
        if(user == null){return false;}
        if(user.getUsername()==null || user.getUsername().trim().isEmpty() || user.getUsername().length()>20){
            return false;
        }
        if(user.getPassword()==null || user.getPassword().trim().isEmpty() || user.getPassword().length()>255){
            return false;
        }
        if(user.getEmail()==null || user.getEmail().trim().isEmpty() || user.getEmail().length()>255){
            return false;
        }
        if(user.getFirstName()==null || user.getFirstName().trim().isEmpty() || user.getFirstName().length()>25){
            return false;
        }
        if(user.getLasName()==null || user.getLasName().trim().isEmpty() || user.getLasName().length()>25){
            return false;
        }
        if(user.getAge()<0 || user.getAge()>200){
            return false;
        }
        return true;
    }

    /**
     * Method for determining whether username is unique.
     * @param username  String of the username to be checked
     * @return          boolean if it is unique(true) or not unique
     */
    public boolean isUserNameAvailable(String username){
       return userDao.isUserNameAvailable(username);
    }


    /**
     * Method for determing whether email is unique.
     * @param email         String email to be checked
     * @return          boolean
     */
    public boolean isEmailAvailalbe(String email){
        return userDao.isEmailAvailalbe(email);
    }


    /**
     * Method to determine username or password is not null, blank, or incorrect.
     * @param username      String
     * @param password      String
     * @return              The user if passed all test
     * @throws AuthenticationException  User provided incorrect login information
     */
    public AppUser authenticate(String username, String password) throws AuthenticationException {
        if(username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
            throw new InvalidRequestException("The provided information is invalid.");
        }
        AppUser user = userDao.findUserByUsernameAndPassword(username,password);
        if(user == null){
            throw new AuthenticationException("Could not find user with provided information.");
        }
        return user;
    }


}
