package ie.ul.cs4084app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {
    private ListView menuListView;
    TextView quantity;
    int quantity1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //quantity = (TextView) findViewByID(R.id.quantity);

        menuListView = findViewById(R.id.menuListView);
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View child, int pos, long _pos){
                //Add item to selection/array
            }
        });

        MenuItem a = new MenuItem("Burger", 2.50);
        MenuItem b = new MenuItem("Sprite", 2.00);
        MenuItem c = new MenuItem("Fries", 1.50);
        MenuItem d = new MenuItem("Ice Cream", 3.50);

        ArrayList<MenuItem> menuList = new ArrayList<>();
        menuList.add(a);
        menuList.add(b);
        menuList.add(c);
        menuList.add(d);



        ArrayList<String> list1 = new ArrayList<>();
        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, R.layout.list_item_menu, list1);

        MenuAdapter menuAdapter = new MenuAdapter(this,R.layout.list_item_menu, menuList);

        menuListView.setAdapter(menuAdapter);

        DatabaseReference reference = FirebaseDatabase.getInstance("https://cs4084app-29f54-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("Restaurant").child("McDonalds"/*RESTAURANT NAME HERE*/).child("Menu");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    list1.add(snapshot.getValue().toString());
                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    //Increment/Decrement quantity
    public void increment(View v){
        //quantity1++;
        //quantity.setText("" + quantity1);
    }
    public void decrement(View v){
        /*if(quantity1 <= 0){
            quantity1 = 0;
        } else {
            quantity1--;
        }
        quantity.setText("" + quantity1);*/
    }
}
