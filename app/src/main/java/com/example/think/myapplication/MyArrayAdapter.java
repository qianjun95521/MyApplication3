package com.example.think.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by think on 2016/1/12.
 */
public class MyArrayAdapter extends ArrayAdapter<MyItem> {
    int resource;
    public MyArrayAdapter(Context context, int resource, List<MyItem> objects) {
        super(context, resource, objects);
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout;
        MyItem myItem=getItem(position);
        String fname=myItem.getName();
        String fage=myItem.getAge();
        if(convertView==null){
linearLayout=new LinearLayout(getContext());
            String inflater=Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li=(LayoutInflater)getContext().getSystemService(inflater);
            li.inflate(resource,linearLayout,true);
        }
        else{
            linearLayout=(LinearLayout)convertView;
        }
        TextView fnameView=(TextView)linearLayout.findViewById(R.id.fname);
        TextView fageView=(TextView)linearLayout.findViewById(R.id.fage);
        fnameView.setText(fname);
        fageView.setText(fage);
        return linearLayout;
    }
}
