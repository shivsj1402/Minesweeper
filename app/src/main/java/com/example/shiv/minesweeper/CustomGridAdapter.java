package com.example.shiv.minesweeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Shiv on 2017-09-29.
 */

public class CustomGridAdapter extends BaseAdapter {
    private Context context;
    private String[][] items;
    LayoutInflater inflator;

    public CustomGridAdapter(Context context, String[][] items){
        this.context= context;
        this.items= items;
        inflator= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return 81;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflator.inflate(R.layout.cell, null);
        }
        TextView tv= (TextView) convertView.findViewById(R.id.textview);
        tv.setText(items[position/9][position%9]);


        return convertView;
    }
}