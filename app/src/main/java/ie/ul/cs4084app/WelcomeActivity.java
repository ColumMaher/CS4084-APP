package ie.ul.cs4084app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

    public void onButtonSignUpClicked(View view){
        Intent intent = new Intent(WelcomeActivity.this, SignUpActivity.class);
        //intent.putExtra("choice", false);
        startActivity(intent);
    }

    public void onButtonSignInClicked(View view){
        Intent intent = new Intent(WelcomeActivity.this, SignInCustomerActivity.class);
        //intent.putExtra("choice", true);
        startActivity(intent);
    }
}