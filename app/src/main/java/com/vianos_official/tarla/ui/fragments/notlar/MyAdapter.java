package com.vianos_official.tarla.ui.fragments.notlar;

import static android.content.Context.MODE_PRIVATE;

import static com.vianos_official.tarla.ui.fragments.notlar.NotlarFragment.sharedPreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vianos_official.tarla.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Not> {
    private final Context context;
    private final ArrayList<Not> values;

    public MyAdapter(Context context, ArrayList<Not> values) {
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textView = rowView.findViewById(R.id.textView);
        FrameLayout frameLayout = rowView.findViewById(R.id.frameLayout);
        FloatingActionButton deleteButton = rowView.findViewById(R.id.delete_button);

        textView.setText(values.get(position).notIsim);

        frameLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("NOT", position);
            context.startActivity(intent);
        });

        deleteButton.setOnClickListener(v -> {
            sharedPreferences.edit().remove(values.get(position).notIsim).apply();

            // Remove the item from the list
            values.remove(position);
            // Notify the adapter to refresh the list view

            notifyDataSetChanged();
        });

        return rowView;
    }
}