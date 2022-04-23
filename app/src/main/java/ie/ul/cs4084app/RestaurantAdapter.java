package ie.ul.cs4084app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    private Context mContext;
    private int mResource;

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Restaurant> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.restaurantpic);

        TextView restaurantDetails = convertView.findViewById(R.id.restaurant_name);

        imageView.setImageResource(getItem(position).getImage());
        restaurantDetails.setText(getItem(position).getAddress());


        return convertView;
    }
}
