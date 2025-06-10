package com.vianos_official.tarla.ui.fragments.notlar;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vianos_official.tarla.R;

import java.util.ArrayList;

public class NotlarFragment extends Fragment {

    private static final int REQUEST_CODE_ADD_NOTE = 1;
    public static SharedPreferences sharedPreferences;
    private MyAdapter adapter;
    public static ArrayList<Not> notlar = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notlar, container, false);


        ListView listView = view.findViewById(R.id.listView);

        sharedPreferences = container.getContext().getSharedPreferences("notlar", MODE_PRIVATE);


        sharedPreferences.getAll().forEach((s, o) -> notlar.add(new Not(s, (String) o)));

        adapter = new MyAdapter(view.getContext(), notlar);
        listView.setAdapter(adapter);


        FloatingActionButton fab = view.findViewById(R.id.notEkle);
        fab.setOnClickListener(this::ekle);

        return view;
    }

    private void ekle(View view) {
        Context context = view.getContext();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Not isimi gir");

        final EditText input = new EditText(context);
        input.setHint("İsim");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setPadding(50, 40, 50, 40);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String newNote = input.getText().toString().trim();
            if (!newNote.isEmpty()) {
                notlar.add(new Not(newNote, ""));
                sharedPreferences.edit().putString(newNote, "").apply();
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(context, "Boş olamaz", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("iptal", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}