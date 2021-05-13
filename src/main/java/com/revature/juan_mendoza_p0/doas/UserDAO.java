package com.revature.juan_mendoza_p0.doas;

import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//user Data Object Access, to persist or get data from the database.
public class UserDAO {


    public AppUser save(AppUser newUser){

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "insert into users.BankUsers (username,password,first_name,last_name,email,age,hasaccount) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"user_id"});
            pstmt.setString(1,newUser.getUsername());
            pstmt.setString(2,newUser.getPassword());
            pstmt.setString(3,newUser.getFirstName());
            pstmt.setString(4,newUser.getLasName());
            pstmt.setString(5,newUser.getEmail());
            pstmt.setInt(6,newUser.getAge());
            pstmt.setInt(7,0);

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

    /**
     * Method to find user in DataBase using USERNAME and PASSWORD
     * @param username  String - username to be checked
     * @param password  String - password to check
     * @return      Appuser, if one is found
     */
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
                user.setAccountCreate(rs.getInt("hasaccount"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    /**
     * Method for determining whether username is unique.
     * @param username  String of the username to be checked
     * @return          boolean if it is unique(true) or not unique
     */
    public boolean isUserNameAvailable(String username){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "select * from users.BankUsers where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return false; //because query found a used username
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return true; //if unique username
    }

    /**
     * Method to verify if email is unique
     * @param email String - email to be checked
     * @return  boolean - true if it unique false otherwise
     */
    public boolean isEmailAvailalbe(String email){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "select * from users.BankUsers where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,email);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return false;//query found an email, so not unique
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return true;
    }

}
