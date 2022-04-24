package ie.ul.cs4084app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {

    private Context mContext;
    int mResource;
    ArrayList<MenuItem> menuList;

    public MenuItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MenuItem> objects) {
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

        TextView itemName = convertView.findViewById(R.id.menuEditorItemName);
        TextView itemPrice = convertView.findViewById(R.id.menuEditorItemPrice);

        itemName.setText(name);
        itemPrice.setText(String.valueOf(price));

        return convertView;
    }
}
