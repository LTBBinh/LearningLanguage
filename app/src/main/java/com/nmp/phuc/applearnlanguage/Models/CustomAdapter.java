package com.nmp.phuc.applearnlanguage.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.nmp.phuc.applearnlanguage.AppRoom.TuVung;
import com.nmp.phuc.applearnlanguage.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AM on 1/20/2018.
 */

public class CustomAdapter extends ArrayAdapter<TuVung>{
    private Context context;
    private int resource;
    private List<TuVung> arrTuVung;
    private ArrayList<Switch> listSwitch;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<TuVung> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrTuVung = objects;
        listSwitch = new ArrayList<>();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.kiemtra_list_item,parent,false);
            holder = new ViewHolder();
            holder.tuView = (TextView) convertView.findViewById(R.id.tuView);
            holder.switchView = (Switch) convertView.findViewById(R.id.itemSwitch);
            convertView.setTag(holder);
            listSwitch.add(holder.switchView);
        }
        else
            holder = (ViewHolder) convertView.getTag();
        TuVung tuVung = arrTuVung.get(position);
        holder.tuView.setText(tuVung.toString());
        return convertView;
    }
    public class ViewHolder {
        TextView tuView;
        Switch switchView;
    }

    public ArrayList<Switch> getListSwitch() {
        return listSwitch;
    }
}
