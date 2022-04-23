package ie.ul.cs4084app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import ie.ul.cs4084app.databinding.ActivityHomeBinding;

public class HomeActivity extends DrawerBaseActivity {

    ActivityHomeBinding activityHomeBinding;
    ListView listView;
    TextView RestaurantName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home");

        RestaurantName = findViewById(R.id.restaurant_name);

        listView = findViewById(R.id.restaurantList);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                return LayoutInflater.from(getBaseContext()).inflate(R.layout.list_item_restaurant, null);
            }
        });
        ArrayList<Restaurant> restaurantData = new ArrayList<>();
        Restaurant a = new Restaurant("McDonalds", "ronald@mcdonalds.com", "1234", "McDonalds \nCASTLETROY SHOPPING CENTRE LIMERICK, V94H029");
        a.setImage(R.drawable.mcdonalds);
        restaurantData.add(a);
        Restaurant b = new Restaurant("Supermacs", "s@macs.com", "1234", "SuperMacs \nDublin Rd, Reboge Meadows, Castletroy, Co. Limerick");
        b.setImage(R.drawable.supermacs);
        restaurantData.add(b);

        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(this, R.layout.list_item_restaurant, restaurantData);

        listView.setAdapter(restaurantAdapter);
    }
}