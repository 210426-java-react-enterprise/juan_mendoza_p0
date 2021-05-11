package com.revature.juan_mendoza_p0.doas;

import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//user Data Object Access, to persist or get data from the database.
public class UserDAO {

    // TODO
    public void save(AppUser newUser){

    }

    public AppUser findUserByUsernameAndPassword(String username, String password){

        AppUser user = null;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "select * from users.users where username=? and password=?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);

            ResultSet rs = prepStmt.executeQuery();

            while(rs.next()){
                user = new AppUser();
               // user.setId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLasName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getInt("age"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
