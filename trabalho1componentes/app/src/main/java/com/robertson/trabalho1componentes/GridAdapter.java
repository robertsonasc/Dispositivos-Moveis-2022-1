package com.robertson.trabalho1componentes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;
    String[] carrosRL;
    int[] image;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] carrosRL, int[] image) {
        this.context = context;
        this.carrosRL = carrosRL;
        this.image = image;
    }

    @Override
    public int getCount() {
        return carrosRL.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

         if(inflater == null)
             inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

         if(convertView == null)
             convertView = inflater.inflate(R.layout.grid_item, null);

        ImageView imageView = convertView.findViewById(R.id.image_view_grid);
        TextView textView = convertView.findViewById(R.id.text_view_grid);

        imageView.setImageResource(image[i]);
        textView.setText(carrosRL[i]);

        return convertView;
    }
}
