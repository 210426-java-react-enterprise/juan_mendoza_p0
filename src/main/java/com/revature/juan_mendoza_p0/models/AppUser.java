package com.revature.juan_mendoza_p0.models;

/**
 * Class to ask for user to input there information to be written to a file for later access.
 */
public class AppUser {
    //Fields of my bank users
    private int id;
    //private double balance;
    private String username;
    private String password;
    private String firstName;
    private String lasName;
    private String email;
    private int age;
    private int accountCreate ;

    public int getAccountCreate() {
        return accountCreate;
    }

    public void setAccountCreate(int accountCreate) {
        this.accountCreate = accountCreate;
    }

    //constructor
    public AppUser(String username, String password, String firstName,
                   String lasName, String email, int age,int accountCreate) {
        this.username = username;
        this.password = password;
        this.firstName= firstName;
        this.lasName = lasName;
        this.email = email;
        this.age = age;
        this.accountCreate = accountCreate;
    }

    public AppUser(int id, String username, String password, String firstName,String lasName, String email, int age,int accountCreate) {
        this(username, password, firstName, lasName, email, age,accountCreate);
        this.id = id;
    }

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppUser(){
        super();
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        return String.format("%s;%s;%s;%s;%s;%d",username,password,firstName,lasName,email,age);
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("AppUser{ ");
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lasName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }


}
