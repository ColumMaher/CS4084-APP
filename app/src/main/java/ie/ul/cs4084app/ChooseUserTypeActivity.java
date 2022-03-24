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
        Intent intent = new Intent(ChooseUserTypeActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void onButtonSupplierClicked(View view){
        //bring user to SupplierSignupActivity
    }
}