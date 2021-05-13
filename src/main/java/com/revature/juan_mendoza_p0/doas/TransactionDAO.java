package com.revature.juan_mendoza_p0.doas;

import com.revature.juan_mendoza_p0.models.Account;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO {


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
