package com.vianos_official.tarla.ui.fragments.isciler;

import static com.vianos_official.tarla.ui.MainActivity.dbHandler;
import static com.vianos_official.tarla.ui.MainActivity.liste;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vianos_official.tarla.R;

public class IscilerFragment extends Fragment {

    IscilerAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_isciler, container, false);


        RecyclerView listeLayout = view.findViewById(R.id.list);
        adapter = new IscilerAdapter();
        listeLayout.setAdapter(adapter);
        listeLayout.setLayoutManager(new LinearLayoutManager(inflater.getContext()));

        FloatingActionButton fab = view.findViewById(R.id.isciEkle);
        fab.setOnClickListener(this::ekle);

        return view;
    }

    private void ekle(View view) {
        Context context = view.getContext();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("İsim gir");

        final EditText input = new EditText(context);
        input.setHint("İsim");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setPadding(50, 40, 50, 40);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String name = input.getText().toString().trim();
            if (!name.isEmpty()) {
                dbHandler.isciEkle(name);
                adapter.notifyItemInserted(liste.size());
            } else {
                Toast.makeText(context, "Name darf nicht leer sein", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Abbrechen", (dialog, which) -> dialog.cancel());

        builder.show();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}