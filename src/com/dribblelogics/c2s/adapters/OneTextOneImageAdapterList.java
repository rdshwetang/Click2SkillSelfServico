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


public class OneTextOneImageAdapterList extends ArrayAdapter<OneTextOneImageAdapterItems>{

    Context context;
    int layoutResourceId;   
    OneTextOneImageAdapterItems data[] = null;
   
    public OneTextOneImageAdapterList(Context context, int layoutResourceId, OneTextOneImageAdapterItems[] data) {
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
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
           
            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }
       
        OneTextOneImageAdapterItems msg = data[position];
        holder.txtTitle.setText(msg.title);
        holder.imgIcon.setImageResource(msg.icon);
       
        return row;
    }
    static class WeatherHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}