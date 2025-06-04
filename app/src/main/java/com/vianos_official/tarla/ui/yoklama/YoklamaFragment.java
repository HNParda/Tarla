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