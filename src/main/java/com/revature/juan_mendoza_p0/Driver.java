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

    /**
     * Method to be able to return app state, be accessible, and loaded before the main method.
     * @return      instance of the AppState
     */
    public static AppState getAppState(){

        return app;
    }
}
