package com.revature.juan_mendoza_p0.util;

public class ConnectionFactory {


    //Singleton Design Pattern:
    //1) will have a private static reference to itself
    //private static ConnectionFactory connectionFactory = new ConnectionFactory(); ---> eager singleton
    private static ConnectionFactory connectionFactory; // lazy singleton


    //by making it private no one can make an instance of this class
    private ConnectionFactory(){
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
    public ConnectionFactory getConnection(){
        return null;
    }
}
