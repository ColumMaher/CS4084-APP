package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {
    private ListView listview1;
    private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listview1 = (ListView) findViewById(R.id.mainListview1);
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View child, int pos, long _pos){
                //Toast.makeText(getApplicationContext(), maplist.get(pos).get("title"), Toast.LENGTH_LONG).show();
            }
        });

    }
}