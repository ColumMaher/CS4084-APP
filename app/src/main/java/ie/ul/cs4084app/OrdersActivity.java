package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ie.ul.cs4084app.databinding.ActivityOrdersBinding;

public class OrdersActivity extends DrawerBaseActivity {

    ActivityOrdersBinding activityOrdersBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrdersBinding = ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(activityOrdersBinding.getRoot());
        allocateActivityTitle("Orders");
    }
}