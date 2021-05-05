package com.revature.juan_mendoza_p0.screens;

public abstract class Screen {
    protected String name;
    protected String route; //variable to tell us where to go..ex)deposit screen

    /**
     * Initialize a created screen with route to be able to navigate.
     *There is a Navigate function within....
     * @param name name of the screen. ex) login, welcome, deposit screen
     * @param route the variable that will be used to navigate screen objects. use following convention
     *              ex) /login or /deposit
     *
     */
    public Screen(String name, String route){
        this.name = name;
        this.route = route;
    }

    /**
     * Method for returning the name of the screen object
     * @return  returns the name of the screen object as String
     */
    public String getName(){
        return name;
    }

    /**
     * Method for returning the route in order to navigate.
     * @return  route name as String
     */
    public String getRoute(){
        return route;
    }

    //render is method for gathering user input, which we need for at minimum
    // be able to navigate switch between screen objects
    public abstract void render();
}
