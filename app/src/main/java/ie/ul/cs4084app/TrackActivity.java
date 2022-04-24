package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ie.ul.cs4084app.databinding.ActivityOrdersBinding;
import ie.ul.cs4084app.databinding.ActivityTrackBinding;

/*public class TrackActivity extends DrawerBaseActivity {

    ActivityTrackBinding activityTrackBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTrackBinding = ActivityTrackBinding.inflate(getLayoutInflater());
        setContentView(activityTrackBinding.getRoot());
        allocateActivityTitle("Track");
    }*/

public class TrackActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng Csbuild = new LatLng(52.67392369916476, -8.575574176442217);
        map.addMarker(new MarkerOptions().position(Csbuild).title("Computer Science Building"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Csbuild));
    }
}