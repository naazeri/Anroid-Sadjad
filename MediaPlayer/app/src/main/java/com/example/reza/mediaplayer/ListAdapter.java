package com.example.reza.mediaplayer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ListAdapter extends BaseAdapter {

    private Context context;
    private static LayoutInflater inflater;
    private List<Item> items;

    public ListAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();
            holder.musicName = (TextView) view.findViewById(R.id.list_row_textView_text);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

//        holder.musicName.setText(items.get(position));

        return view;
    }

    public static class ViewHolder {
        public TextView musicName;
        public ImageView musicImage;
    }
}
