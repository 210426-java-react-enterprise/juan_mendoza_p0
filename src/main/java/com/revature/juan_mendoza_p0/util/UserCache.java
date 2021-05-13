package com.revature.juan_mendoza_p0.util;

/**
 * class for temporarily storing user information.
 */
public class UserCache {

    private String currentUserName;
    private String currentPassword;
    private int hasAccount;

    public int getHasAccount() {
        return hasAccount;
    }

    public void setHasAccount(int hasAccount) {
        this.hasAccount = hasAccount;
    }

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
