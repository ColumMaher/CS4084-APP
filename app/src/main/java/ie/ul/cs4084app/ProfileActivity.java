package ie.ul.cs4084app;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ie.ul.cs4084app.databinding.ActivityCartBinding;
import ie.ul.cs4084app.databinding.ActivityProfileBinding;

public class ProfileActivity extends DrawerBaseActivity {

    private TextView name_textView, email_textView, number_textView;
    private ImageView imageview6, name_imageView, email_imageView, number_imageView;
    private String email;
    private static final String USERS = "users";
    private DatabaseReference mDatabase;
    private FirebaseDatabase   database;



    FirebaseDatabase database = FirebaseDatabase.getInstance("https://cs4084app-29f54-default-rtdb.europe-west1.firebasedatabase.app");

    ActivityProfileBinding activityProfileBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_profile));

        
        //hooks
        name_textView = findViewById(R.id.name_textView);
        email_textView = findViewById(R.id.email_textView);
        number_textView = findViewById(R.id.number_textView);
        name_imageView = findViewById(R.id.name_imageView);
        email_imageView = findViewById(R.id.email_imageView);
        number_imageView = findViewById(R.id.number_imageView);

        //Show all data 
        showAllUserData();



        /*activityProfileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(activityProfileBinding.getRoot());
        allocateActivityTitle("Profile");

        Intent intent = getIntent();
        String email = intent.getStringExtra("email")

        name_textView = findViewById(R.id.name_textView);
        email_textView = findViewById(R.id.email_textView);
        number_textView = findViewById(R.id.number_textView);
        name_imageView = findViewById(R.id.name_imageView);
        email_imageView = findViewById(R.id.email_imageView);
        number_imageView = findViewById(R.id.number_imageView);

        database = FirebaseDatabase.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference(USERS);
        DatabaseReference myRef = database.getReference("Message");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    if()
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        })


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        }); */
    }

    private void showAllUserData() {

        Intent intent = getIntent();
        String user_username = intent.getStringExtra("UserName");
        String user_email = intent.getStringExtra("Email");
        String user_mobileNumber = intent.getStringExtra("MobileNumber");

        name_textView.setText(user_username);
        email_textView.setText(user_email);
        number_textView.setText(user_mobileNumber);
    }
}
