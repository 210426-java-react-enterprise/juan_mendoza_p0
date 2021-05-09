package com.revature.juan_mendoza_p0;


import com.revature.juan_mendoza_p0.util.AppState;

public class Driver {

    //will run before main method
    private static AppState app = new AppState();

    public static void main(String[] args){

        while (app.isAppRunning()){
            app.getRouter().navigate("/welcome");// will navigate us to welcome screen, more options.
        }
    }

    public static AppState getAppState(){
        return app;
    }
}
