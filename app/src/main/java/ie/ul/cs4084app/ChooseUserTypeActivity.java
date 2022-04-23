package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseUserTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_type);
    }

    public void onButtonCustomerClicked(View view){
        boolean choice = false;
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            choice = extras.getBoolean("choice");
        }
        if (!choice) {
            Intent intent = new Intent(ChooseUserTypeActivity.this, SignUpActivity.class);
            startActivity(intent);
        } else{
            Intent intent = new Intent(ChooseUserTypeActivity.this, SignInCustomerActivity.class);
            startActivity(intent);
        }
    }

    public void onButtonSupplierClicked(View view){
        boolean choice = false;
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            choice = extras.getBoolean("choice");
        }
        if (!choice) {
            Intent intent = new Intent(ChooseUserTypeActivity.this, SignUpRestaurantActivity.class);
            startActivity(intent);
        } else{
            Intent intent = new Intent(ChooseUserTypeActivity.this, SignInCustomerActivity.class);
            startActivity(intent);
        }
    }
}