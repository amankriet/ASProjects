package com.amankriet.virusishere.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {


    public MyAdapter(@NonNull Context context, String[] values) {
        super(context, R.layout.second_layout, values);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater theinflator = LayoutInflater.from(getContext());
        View theview = theinflator.inflate(R.layout.second_layout, parent, false);
        String list = getItem(position);
        TextView tv = theview.findViewById(R.id.textview1);
        tv.setText(list);
        ImageView iv = theview.findViewById(R.id.imageview1);
        iv.setImageResource(R.drawable.dot);
        return theview;
    }
}
