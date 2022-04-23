package ie.ul.cs4084app;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> menu;

    //All new restaurants will have this default menu until they edit them
    public Menu() {
        MenuItem a = new MenuItem("Burger", 2.50);
        MenuItem b = new MenuItem("Sprite", 2.00);
        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(a);
        menu.add(b);
        this.menu = menu;
    }
    public void addItem(MenuItem m){
        menu.add(m);
    }
    public void removeItem(MenuItem m){
        menu.remove(m);
    }

}
