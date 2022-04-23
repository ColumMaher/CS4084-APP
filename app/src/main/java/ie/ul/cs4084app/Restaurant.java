package ie.ul.cs4084app;

public class Restaurant {
    private int image;
    private String name;
    private String email;
    private String Password;
    private String address;
    private Menu menu;

    public Restaurant(String name, String email, String Password, String address) {
        this.name = name;
        this.email = email;
        this.Password = Password;
        this.address = address;
        this.menu = new Menu();
    }

    public void setImage(int image){
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
