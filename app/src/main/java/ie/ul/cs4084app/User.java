package ie.ul.cs4084app;

public class User {

    public String UserName;
    public String Password;
    public String Email;
    public String MobileNumber;

    public User(){

    }
    public User(String username, String password, String email, String mobileNo){
        this.UserName = username;
        this.Password = password;
        this.Email = email;
        this.MobileNumber = mobileNo;
    }
}
