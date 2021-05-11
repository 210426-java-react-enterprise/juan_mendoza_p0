package com.revature.juan_mendoza_p0.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {


    //Singleton Design Pattern:
    //1) will have a private static reference to itself
    //private static ConnectionFactory connectionFactory = new ConnectionFactory(); ---> eager singleton
    private static ConnectionFactory connectionFactory; // lazy singleton

    //for reading property files
    private Properties props = new Properties();

    //need to load postgres into memory before tyring to access it
    static{
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    //by making it private no one can make an instance of this class
    private ConnectionFactory(){
        try {
            props.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //lazy singleton because we don't create instance until this method is called
    public static ConnectionFactory getInstance(){
        if(connectionFactory == null){
            connectionFactory = new ConnectionFactory();
            return connectionFactory;
        }
        return connectionFactory;
    }

    //instance method, get instance of ConnectionFactory first then this method.
    public Connection getConnection(){

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(
                    props.getProperty("host-url"),
                    props.getProperty("username"),
                    props.getProperty("password"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
