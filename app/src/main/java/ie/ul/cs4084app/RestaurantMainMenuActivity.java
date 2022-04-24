package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RestaurantMainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main_menu);
    }

    public void restaurantMenuClick(View v){
        Intent intent = new Intent(RestaurantMainMenuActivity.this, MenuEditorActivity.class);
        startActivity(intent);
    }
}