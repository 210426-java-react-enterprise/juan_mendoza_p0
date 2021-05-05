package com.revature.juan_mendoza_p0.doas;

import com.revature.juan_mendoza_p0.models.AppUsers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * When we register a user, we save the information to file(resources/user.txt).
 */
public class UserDOA {
    public void saveUserToFile(AppUsers newUser){

        //Buffered writer to write the user input data
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/user.txt",true))){
            writer.write(newUser.toFileString()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
