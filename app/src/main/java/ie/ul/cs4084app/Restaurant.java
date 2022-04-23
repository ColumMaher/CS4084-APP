package ie.ul.cs4084app;

import java.util.HashMap;

public class Restaurant {
    private int image;
    private String name;
    private String email;
    private String Password;
    private String address;
    HashMap<String, Object> menu = new HashMap<>();

    public Restaurant(String name, String email, String Password, String address) {
        this.name = name;
        this.email = email;
        this.Password = Password;
        this.address = address;
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

    public HashMap<String, Object> getMenu() {
        return menu;
    }

    public void setMenu(HashMap<String, Object> menu) {
        this.menu = menu;
    }
    public void addMenuItem(String name, double price){
        menu.put(name, price);
    }
    public void removeMenuItem(String name){
        menu.remove(name);
    }
}
