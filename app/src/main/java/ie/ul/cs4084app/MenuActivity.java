package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {
    private ListView menuListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuListView = findViewById(R.id.menuListView);
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View child, int pos, long _pos){
                //Add item to selection/array
            }
        });

        Restaurant mcDonalds = new Restaurant("McDonalds1", "1111@mail.com", "1244", "McDonalds \nCRESCENT SHOPPING CENTRE LIMERICK, V94H029");
        mcDonalds.addMenuItem("Pizza", 4.0);
        mcDonalds.addMenuItem("7up", 3.0);
        mcDonalds.addMenuItem("Chicken", 3.5);
        mcDonalds.getMenu();

        //ArrayList of menu items
        ArrayList<String> selectedMenu= new ArrayList<>();
        for(String s : mcDonalds.getMenu().keySet()){
            selectedMenu.add(s);
        }
        //ArrayList of menu item prices
        ArrayList<Object> selectedMenuPrice= new ArrayList<>();
        for(Object o : mcDonalds.getMenu().values()){
            selectedMenuPrice.add(o);
        }
        //System.out.println(selectedMenu);
        //System.out.println(selectedMenuPrice);

        MenuAdapter menuAdapter = new MenuAdapter(this,R.layout.list_item_menu,selectedMenu);
        menuListView.setAdapter(menuAdapter);
    }
}