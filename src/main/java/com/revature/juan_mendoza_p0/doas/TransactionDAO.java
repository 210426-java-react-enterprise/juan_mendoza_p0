package com.revature.juan_mendoza_p0.doas;

import com.revature.juan_mendoza_p0.models.Account;
import com.revature.juan_mendoza_p0.models.AppUser;
import com.revature.juan_mendoza_p0.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO {


    public void createAccount(AppUser user, String accountType, Account acc){

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            System.out.println("Now creating a " + accountType+ " account.");

            String sql = "insert into accounts(account_type, user_id) values(?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,accountType);
            pstmt.setInt(2,user.getId());

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

}
