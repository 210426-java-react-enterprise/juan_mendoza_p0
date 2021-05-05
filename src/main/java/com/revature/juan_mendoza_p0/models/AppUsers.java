package com.revature.juan_mendoza_p0.models;

/**
 * Class to ask for user to input there information to be written to a file for later access.
 */
public class AppUsers {
    //Fields of my bank users
    private String username;
    private String password;
    private String fristName;
    private String lasName;
    private String email;
    private int age;

    //constructor
    public AppUsers(String username, String password, String fristName,
                    String lasName, String email, int age) {
        this.username = username;
        this.password = password;
        this.fristName = fristName;
        this.lasName = lasName;
        this.email = email;
        this.age = age;
    }
    //getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toFileString(){
        return String.format("%s;%s;%s;%s;%s;%d",username,password,fristName,lasName,email,age);
    }
}
