package com.revature.juan_mendoza_p0.util;

import com.revature.juan_mendoza_p0.screens.Screen;

public class ScreenRouter {

    private LinkedList<Screen> screens = new LinkedList<>();

    //can chain add methods foo.add( foo dog) .add(foo dog)
    //builder patter -- return the instance of this ScreenRouter object
    public ScreenRouter addScreen(Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate (String route){
        for (int i = 0; i< screens.size(); i++){
            Screen screen = screens.get(i);
            if(screen.getRoute().equals(route)){
                screen.render();
            }
        }
    }

}
