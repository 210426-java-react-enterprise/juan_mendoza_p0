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
    public AppUser save(AppUser newUser){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "insert into users.BankUsers (username,password,first_name,last_name,email,age) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"user_id"});
            pstmt.setString(1,newUser.getUsername());
            pstmt.setString(2,newUser.getPassword());
            pstmt.setString(3,newUser.getFirstName());
            pstmt.setString(4,newUser.getLasName());
            pstmt.setString(5,newUser.getEmail());
            pstmt.setInt(6,newUser.getAge());

            int rowInserted = pstmt.executeUpdate();

            if(rowInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newUser.setId(rs.getInt("user_id"));
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return newUser;

    }

    public AppUser findUserByUsernameAndPassword(String username, String password){

        AppUser user = null;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "select * from users.BankUsers where username=? and password=?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);

            ResultSet rs = prepStmt.executeQuery();

            while(rs.next()){
                user = new AppUser();
                user.setId(rs.getInt("user_id"));
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