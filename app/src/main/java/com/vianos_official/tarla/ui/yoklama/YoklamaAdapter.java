package com.vianos_official.tarla.ui.yoklama;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vianos_official.tarla.R;
import com.vianos_official.tarla.Isci;

import java.time.LocalDate;
import java.util.ArrayList;

public class YoklamaAdapter extends RecyclerView.Adapter<YoklamaAdapter.YoklamaViewHolder> {

    ArrayList<Isci> liste;
    LocalDate date = LocalDate.now();

    public YoklamaAdapter(ArrayList<Isci> liste) {
        this.liste = liste;
    }


    @NonNull
    @Override
    public YoklamaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.liste_yoklama, parent, false);
        YoklamaViewHolder viewHolder = new YoklamaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YoklamaViewHolder holder, int position) {
        holder.goster(liste.get(position), date);
    }


    @Override
    public int getItemCount() {
        return liste.size();
    }


    static class YoklamaViewHolder extends RecyclerView.ViewHolder {

        View kisi;
        TextView isim;
        CheckBox geldi;
        CheckBox odendi;

        public YoklamaViewHolder(@NonNull View view) {
            super(view);

            kisi = view;

            isim = kisi.findViewById(R.id.isim);
            geldi = kisi.findViewById(R.id.geldi);
            odendi = kisi.findViewById(R.id.odendi);
        }

        public void goster(Isci isci, LocalDate tarih) {
            isim.setText(isci.ISIM);
            geldi.setChecked(isci.yoklama.contains(tarih));
            odendi.setChecked(isci.odeme.contains(tarih));
        }
    }
}
