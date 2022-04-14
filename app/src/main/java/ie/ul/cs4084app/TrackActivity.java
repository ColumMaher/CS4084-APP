package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ie.ul.cs4084app.databinding.ActivityOrdersBinding;
import ie.ul.cs4084app.databinding.ActivityTrackBinding;

public class TrackActivity extends DrawerBaseActivity {

    ActivityTrackBinding activityTrackBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTrackBinding = ActivityTrackBinding.inflate(getLayoutInflater());
        setContentView(activityTrackBinding.getRoot());
        allocateActivityTitle("Track");
    }
}