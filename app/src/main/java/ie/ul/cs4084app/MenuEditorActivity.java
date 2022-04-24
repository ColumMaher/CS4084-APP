package ie.ul.cs4084app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PatternMatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuEditorActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<MenuItem> menuList;
    MenuItemAdapter adapter;

    EditText inputName;
    EditText inputPrice;
    ImageView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_editor);

        listView = findViewById(R.id.restaurantmenueditorlist);
        inputName = findViewById(R.id.menuinput);
        inputPrice = findViewById(R.id.menuinput2);
        enter = findViewById(R.id.addmenuitem);

        MenuItem a = new MenuItem("Burger", 2.50);
        MenuItem b = new MenuItem("Sprite", 2.00);
        MenuItem c = new MenuItem("Fries", 1.50);
        MenuItem d = new MenuItem("Ice Cream", 3.50);


        ArrayList<MenuItem> menuList = new ArrayList<>();
        menuList.add(a);
        menuList.add(b);
        menuList.add(c);
        menuList.add(d);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuEditorActivity.this, "Removed: " + menuList.get(i).getName(), Toast.LENGTH_SHORT).show();
                menuList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        adapter = new MenuItemAdapter(this, R.layout.adapter_menu_editor, menuList);
        listView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtname = inputName.getText().toString();
                Double txtprice = Double.valueOf(inputPrice.getText().toString());

                    //Add new item to menu
                    MenuItem a = new MenuItem(txtname, txtprice);
                    menuList.add(a);
                    adapter.notifyDataSetChanged();

                    //Clear input fields
                    inputName.setText("");
                    inputPrice.setText("");
                    Toast.makeText(MenuEditorActivity.this, "Added: " + txtname, Toast.LENGTH_LONG).show();

            }
        });
    }
}