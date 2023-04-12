package src.indi.wree.gymManagement.bean;

public class User {

// properties for users
    private String username;
    private String password;
    private int userType;


//  setter and getter for variables


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


    public int isUserType() {

        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
