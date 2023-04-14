package src.indi.wree.gymManagement.bean;

public class Members {

// properties for gym members;
    private String name;
    private String password;

    private String Email;
    private String cellPhone;

    private String homeClub;

    private int type;

//setter and getter for all the variables


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }



    public String getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(String homeClub) {
        this.homeClub = homeClub;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
