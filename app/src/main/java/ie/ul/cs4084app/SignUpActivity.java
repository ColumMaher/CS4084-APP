package ie.ul.cs4084app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextPassword;
    EditText editTextEmail;
    EditText editTextMobileNumber;

    ProgressBar progressBar;
    private Task<Void> db;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMobileNumber = findViewById(R.id.editTextMobileNumber);
        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();

    }

    public void signupButtonClicked(View v){

        String UserName = editTextUserName.getText().toString().trim();
        String Password = editTextPassword.getText().toString().trim();
        String Email = editTextEmail.getText().toString().trim();
        String MobileNumber = editTextMobileNumber.getText().toString().trim();

        //Checking for empty fields
        if(UserName.isEmpty()){
            editTextUserName.setError("Please enter User Name");
            editTextUserName.requestFocus();
            return;
        }
        if(Password.isEmpty() || Password.length() < 6){
            editTextPassword.setError("Please enter a Password containing at least 6 characters");
            editTextPassword.requestFocus();
            return;
        }
        if(Email.isEmpty()){
            editTextEmail.setError("Please enter an Email Address");
            editTextEmail.requestFocus();
            return;
        }
        if(MobileNumber.isEmpty()){
            editTextMobileNumber.setError("Please enter a Phone Number");
            editTextMobileNumber.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        //Creating User in firebase
        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Create user object then add to Firebase
                            User user = new User(UserName, Password, Email, MobileNumber);

                            FirebaseDatabase.getInstance("https://cs4084app-29f54-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())/*Here user is identified by firebase auth ID*/
                                    .setValue(user).addOnCompleteListener(task1 -> {
                                        if (task1.isSuccessful()){
                                            Toast.makeText(SignUpActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                            //add intent to bring user to login/home screen after successful register here
                                        }
                                        else {
                                            Toast.makeText(SignUpActivity.this, "User Failed to Register Code:1", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    });
                        }
                        else {
                            Toast.makeText(SignUpActivity.this, "User Failed to Register Code:2", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}