/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.c2s.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dribblelogics.c2sselfservico.R;


public class ThreeTextOneImageListAdapter extends ArrayAdapter<ThreeTextOneImageAdapterItems>{

    Context context;
    int layoutResourceId;   
    ThreeTextOneImageAdapterItems data[] = null;
   
    public ThreeTextOneImageListAdapter(Context context, int layoutResourceId, ThreeTextOneImageAdapterItems[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
       
    	View row = convertView;
        WeatherHolder holder = null;
       
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new WeatherHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.sub_menu_image);
            holder.txtTitle1 = (TextView)row.findViewById(R.id.sub_menu_name);
            holder.txtTitle2 = (TextView)row.findViewById(R.id.sub_menu_quantity);
            holder.txtTitle3 = (TextView)row.findViewById(R.id.sub_menu_price);
            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }
       
        ThreeTextOneImageAdapterItems msg = data[position];
        holder.txtTitle1.setText(msg.title1);
        holder.txtTitle2.setText(msg.title2);
        holder.txtTitle3.setText(msg.title3);
        holder.imgIcon.setImageResource(msg.icon);
       
        return row;
    }
    static class WeatherHolder
    {
        ImageView imgIcon;
        TextView txtTitle1;
        TextView txtTitle2;
        TextView txtTitle3;
    }
}