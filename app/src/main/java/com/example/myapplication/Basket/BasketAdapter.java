package com.example.myapplication.Basket;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.myapplication.Constants.BaseUrlUpload;

public class BasketAdapter extends ArrayAdapter<Basket> {

    Activity context;
    int resource;
    List<Basket> objects;
    /**
     * @param context
     * @param resource
     * @param objects
     * */
    public BasketAdapter(Activity context, int resource, List<Basket> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);

        TextView name = (TextView) customView.findViewById(R.id.namebasket);
        TextView price = (TextView) customView.findViewById(R.id.pricebasket);
        ImageView img = (ImageView) customView.findViewById(R.id.imagebasket);
        /** Set data to custumView*/
        final Basket basket = this.objects.get(position);
        name.setText(basket.getNameProduct());
        price.setText(basket.getPriceProduct()+" VNĐ ");
        Picasso.with(getContext()).load(BaseUrlUpload+basket.getImageProduct()).into(img);
        /**Set Event Onclick*/

        return customView;
    }
    /** Show mesage*/

}
