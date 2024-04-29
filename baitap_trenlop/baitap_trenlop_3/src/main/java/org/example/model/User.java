package model;

public class User {
    protected int userID;
    protected String userName;
    protected String email;
    protected String country;

    public User() {}

    public User(String userName, String email, String country) {
        this.userName = userName;
        this.email = email;
        this.country = country;
    }

    public User(int userID, String userName, String email, String country) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.country = country;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
