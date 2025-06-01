package com.vianos_official.tarla.ui.yoklama;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vianos_official.tarla.R;
import com.vianos_official.tarla.Isci;

import java.util.ArrayList;

public class YoklamaFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yoklama, container, false);

        ArrayList<Isci> liste = new ArrayList<>();

        Isci isci1 = new Isci();
        isci1.ISIM = "Arda";
        Isci isci2 = new Isci();
        isci2.ISIM = "Arda 21";
        Isci isci3 = new Isci();
        isci3.ISIM = "Arda gefda";
        Isci isci4 = new Isci();
        isci4.ISIM = "Arda gsfda";
        Isci isci5 = new Isci();
        isci5.ISIM = "Arda gadfs";
        Isci isci6 = new Isci();
        isci6.ISIM = "Arda gadf";
        Isci isci7 = new Isci();
        isci7.ISIM = "Arda afsf";
        Isci isci8 = new Isci();
        isci8.ISIM = "Arda adsa";

        liste.add(isci1);
        liste.add(isci2);
        liste.add(isci3);
        liste.add(isci4);
        liste.add(isci5);
        liste.add(isci6);
        liste.add(isci7);
        liste.add(isci8);

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