package com.revature.juan_mendoza_p0.util;


public class UserCache {

    private String currentUserName;
    private String currentPassword;

    public UserCache(){
        super();
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
}
