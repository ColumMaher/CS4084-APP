package ie.ul.cs4084app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInCustomerActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword;
    TextView textViewForgotPassword, textViewRegister;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_customer);

        editTextUserName = (EditText) findViewById(R.id.editTextSignInCustomerUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextSignInCustomerPassword);

        textViewForgotPassword = (TextView) findViewById(R.id.txtSignInForgotPassword);
        textViewRegister = (TextView) findViewById(R.id.txtSignInRegister);

        progressBar = (ProgressBar) findViewById(R.id.progressBarSignInCustomer);

        mAuth = FirebaseAuth.getInstance();
    }

    public void txtCustomerSignInForgotPasswordClicked(View v){
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
    public void txtCustomerSignInRegisterClicked(View v){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
    public void buttonSignInScreenSignInClicked(View v){

        String userName = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //Error checks
        if (!Patterns.EMAIL_ADDRESS.matcher(userName).matches() || userName.isEmpty()) {
            editTextUserName.setError("Please enter a Valid Email");
            editTextUserName.requestFocus();
            return;
        }

        if (editTextPassword.length() < 6 || password.isEmpty()) {
            editTextPassword.setError("Password must be at least 6 characters");
            editTextPassword.requestFocus();
            return;
        }
        //Show loading bar while processing
        progressBar.setVisibility(View.VISIBLE);

        //Firebase authentication method with Toast feedback
        mAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignInCustomerActivity.this, "User has successfully Signed In", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);

                    startActivity(new Intent(SignInCustomerActivity.this, DashboardActivity.class));
                }
                else {
                    Toast.makeText(SignInCustomerActivity.this, "User has failed to Signed In", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
    public void isUser() {

        final String userEnteredUsername = editTextUserName.getText().toString().trim();
        final String userEnteredPassword = editTextPassword.getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance("https://cs4084app-29f54-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");

        Query checkUser = reference.orderByChild("UserName").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {

                    editTextUserName.setError(null);


                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("Password").getValue(String.class);

                    if(passwordFromDB.equals(userEnteredPassword)){

                        String userNameFromDB = dataSnapshot.child(userEnteredUsername).child("UserName").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("Email").getValue(String.class);
                        String mobileNumberFromDB = dataSnapshot.child(userEnteredUsername).child("MobileNumber").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);

                        intent.putExtra("name", userNameFromDB);
                        intent.putExtra("Email", emailFromDB);
                        intent.putExtra("MobileNumber", mobileNumberFromDB);

                        startActivity(intent);

                    }
                    else{
                        editTextPassword.setError("Wrong Password");
                        editTextPassword.requestFocus();
                    }
                }
                else{
                    editTextUserName.setError("Wrong Username");
                    editTextUserName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }



        });
    }
}
