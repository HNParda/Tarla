package com.vianos_official.tarla.ui.ayarlar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vianos_official.tarla.DBHandler;
import com.vianos_official.tarla.Isci;
import com.vianos_official.tarla.R;
import com.vianos_official.tarla.ui.yoklama.YoklamaAdapter;

import java.util.ArrayList;

public class AyarlarFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ayarlar, container, false);


        DBHandler dbHandler = new DBHandler(view.getContext());

        ArrayList<Isci> liste = dbHandler.getIsciListe();


        RecyclerView listeLayout = view.findViewById(R.id.list);
        YoklamaAdapter adapter = new YoklamaAdapter(liste);
        listeLayout.setAdapter(adapter);
        listeLayout.setLayoutManager(new LinearLayoutManager(inflater.getContext()));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}