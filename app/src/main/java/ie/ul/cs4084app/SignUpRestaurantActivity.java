package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SignUpRestaurantActivity extends AppCompatActivity {

    EditText editTextRestaurantName;
    EditText editTextRestaurantPassword;
    EditText editTextRestaurantEmail;
    EditText editTextPostalAddress1;
    EditText editTextPostalAddress2;
    EditText editTextCity;
    EditText editTextPostCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_restaurant);

        editTextRestaurantName = findViewById(R.id.editTextRestaurantName);
        editTextRestaurantPassword = findViewById(R.id.editTextRestaurantEmail);
        editTextRestaurantEmail = findViewById(R.id.editTextPassword);
        editTextPostalAddress1 = findViewById(R.id.editTextPostalAddress1);
        editTextPostalAddress2 = findViewById(R.id.editTextPostalAddress2);
        editTextCity = findViewById(R.id.editTextCity);
        editTextPostCode = findViewById(R.id.editTextPostCode);

    }
}