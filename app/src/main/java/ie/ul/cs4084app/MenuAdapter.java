package ie.ul.cs4084app;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuItem> {
    int mResource;
    private Context mContext;
    ArrayList<MenuItem> menuList;
    public MenuAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MenuItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        menuList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = menuList.get(position).getName();
        Double price = menuList.get(position).getPrice();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView itemName = convertView.findViewById(R.id.itemName);
        TextView itemPrice = convertView.findViewById(R.id.itemPrice);

        itemName.setText(name);
        itemPrice.setText(String.valueOf(price));


         Button buttonDec = (Button) convertView.findViewById(R.id.buttonDec);
        Button buttonInc = (Button) convertView.findViewById(R.id.buttonInc);
        TextView quantity = (TextView) convertView.findViewById(R.id.quantity);
        
        buttonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q = Integer.parseInt(quantity.getText().toString());
                if (q > 0) {
                    q = q-1;
                    quantity.setText(q + "");
                    notifyDataSetChanged();
                }
            }
        });

        buttonInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q = Integer.parseInt(quantity.getText().toString());
                q = q+1;
                quantity.setText(q+"");
                notifyDataSetChanged();
            }
        });
        
        return convertView;
    }
}
