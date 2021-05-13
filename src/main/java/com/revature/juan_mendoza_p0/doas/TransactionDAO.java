package com.revature.juan_mendoza_p0.doas;

import com.revature.juan_mendoza_p0.models.Account;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO {


    /**
     * Method to create account
     * @param username
     * @param accountType
     * @param acc
     */
    public void createAccount(String username, String accountType, Account acc){

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Now creating a " + accountType+ " account.");

            String sql = "insert into users.accounts(account_type, username) values(?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,accountType);
            pstmt.setString(2,username);

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    acc.setAccountId(rs.getInt("account_id"));
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(accountType + " has been created.");
    }

    /**
     * Create Checking Account in the database for the user
     * @param username
     */
    public void createCheckingAccount(String username){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "insert into users.checking(balance,username) values(?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,0);
            pstmt.setString(2,username);

            int rowsInserted = pstmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Method to update user if they have created an account
     *
     * @param username
     */
    public void updateAccountCreation(String username){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "update users.bankusers set hasaccount = (?) where username = (?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,1);
            pstmt.setString(2,username);

            int rowsInserted = pstmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Method to deposit the amount desire to user in the database
     * @param amount    amount to be deposited
     * @param username  username to look for in the database
     */
    public void depositBalance(double amount,String username){
        double newBalance = amount +getCheckingBalance(username);
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "update users.checking set balance =(?) where username=(?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,newBalance);
            pstmt.setString(2,username);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("Funds have been deposited!");
    }

    /**
     * Method to get balance from the database using username
     * @param username  String - username to access the database
     * @return  double the balance from the user
     */
    public double getCheckingBalance(String username){
        double sqlBalance=0.0;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "select balance from users.checking where username =(?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                sqlBalance = rs.getDouble("balance");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return sqlBalance;
    }

    /**
     * Method to withdraw funds from the DataBase using username
     * @param username  String - username to check data base and access balance
     * @param amount    double - desired amount to be taken out of balance
     * @return      double - the new balance
     */
    public double withdrawFromBalance(String username, double amount){
        double newBalance = getCheckingBalance(username) - amount;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "update users.checking set balance=(?) where username=(?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, newBalance);
            pstmt.setString(2,username);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("$ " + amount+ " has been withdrawn.");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        return newBalance;
    }



}
