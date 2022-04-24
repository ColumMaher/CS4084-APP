package ie.ul.cs4084app;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpRestaurantActivity extends AppCompatActivity {

    EditText editTextRestaurantName;
    EditText editTextRestaurantPassword;
    EditText editTextRestaurantEmail;
    EditText editTextPostalAddress1;
    EditText editTextPostalAddress2;
    EditText editTextCity;
    EditText editTextPostCode;

    ProgressBar progressBar;
    private Task<Void> db;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_restaurant);

        editTextRestaurantName = findViewById(R.id.editTextRestaurantName);
        editTextRestaurantEmail = findViewById(R.id.editTextRestaurantEmail);
        editTextRestaurantPassword = findViewById(R.id.editTextPassword);
        editTextPostalAddress1 = findViewById(R.id.editTextPostalAddress1);
        editTextPostalAddress2 = findViewById(R.id.editTextPostalAddress2);
        editTextCity = findViewById(R.id.editTextCity);
        editTextPostCode = findViewById(R.id.editTextPostCode);
        progressBar = findViewById(R.id.progressBar2);
        mAuth = FirebaseAuth.getInstance();

    }
    public void signupRestaurantButtonClicked(View v) {

        String RestaurantName = editTextRestaurantName.getText().toString().trim();
        String Password = editTextRestaurantPassword.getText().toString().trim();
        String Email = editTextRestaurantEmail.getText().toString().trim();
        String Address = editTextPostalAddress1.getText().toString().trim() + " " + editTextPostalAddress2.getText().toString().trim()
                + " " + editTextCity.getText().toString().trim()
                + " " + editTextPostCode.getText().toString().trim();

        //Checking for empty fields
        if (RestaurantName.isEmpty()) {
            editTextRestaurantName.setError("Please enter Restaurant Name");
            editTextRestaurantName.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches() || Email.isEmpty()) {
            editTextRestaurantEmail.setError("Please enter an Email Address");
            editTextRestaurantEmail.requestFocus();
            return;
        }
        if (Password.isEmpty() || Password.length() < 6) {
            editTextRestaurantPassword.setError("Please enter a Password containing at least 6 characters");
            editTextRestaurantPassword.requestFocus();
            return;
        }
        if (Address.isEmpty()) {
            editTextPostalAddress1.setError("Please enter an Address");
            editTextPostalAddress1.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //Creating User in firebase
        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            //Create a default menu for Restaurants
                            HashMap<String, Object> defaultMenu = new HashMap<>();
                            defaultMenu.put("Burger", 2.50);
                            defaultMenu.put("Sprite", 2.00);

                            //Create and add new restaurant user
                            Restaurant r = new Restaurant(RestaurantName,Email,Password,Address);

                            FirebaseDatabase.getInstance("https://cs4084app-29f54-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Restaurant")
                                    .child(RestaurantName)/*Restaurant Name main identifier in Database*/
                                    .setValue(r).addOnCompleteListener(task1 -> {
                                if (task1.isSuccessful()){

                                    //Add Menu after adding Restaurant, we want the menu as a child
                                    //Didn't find a way to do it one query
                                    r.setMenu(defaultMenu);

                                    FirebaseDatabase.getInstance("https://cs4084app-29f54-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Restaurant/" + RestaurantName)
                                            .child("Menu")/*Restaurant Name main identifier in Database*/
                                            .setValue(r.getMenu());
                                    Toast.makeText(SignUpRestaurantActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);
                                    //add intent to bring user to login/home screen after successful register here
                                }
                                else {
                                    Toast.makeText(SignUpRestaurantActivity.this, "User Failed to Register Code:1", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            });
                        }
                        else {
                            Toast.makeText(SignUpRestaurantActivity.this, "User Failed to Register Code:2", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}