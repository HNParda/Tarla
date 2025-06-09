package com.vianos_official.tarla.ui.fragments.yoklama;

import static com.vianos_official.tarla.ui.MainActivity.dbHandler;
import static com.vianos_official.tarla.ui.MainActivity.liste;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vianos_official.tarla.Isci;
import com.vianos_official.tarla.Kayit;
import com.vianos_official.tarla.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class YoklamaAdapter extends RecyclerView.Adapter<YoklamaAdapter.YoklamaViewHolder> {

    LocalDate date;

    public YoklamaAdapter() {
        date = LocalDate.now();
    }


    @NonNull
    @Override
    public YoklamaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.liste_yoklama, parent, false);
        YoklamaViewHolder viewHolder = new YoklamaViewHolder(view);
        return viewHolder;
    }

    public void tarihDegistir(LocalDate date) {
        kaydet();
        this.date = date;
        notifyItemRangeChanged(0, liste.size() - 1);
    }

    public void oncekiGun() {
        kaydet();
        date = date.minusDays(1);
        // notifyItemRangeChanged(0, liste.size() - 1);
        notifyDataSetChanged();
    }

    public void sonrakiGun() {
        kaydet();
        date = date.plusDays(1);
       // notifyItemRangeChanged(0, liste.size() - 1);
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull YoklamaViewHolder holder, int position) {
        holder.goster(date);
    }


    @Override
    public int getItemCount() {
        return liste.size();
    }

    public void kaydet() {

        ArrayList<Kayit> kayitListe = new ArrayList<>();
        liste.forEach(isci -> kayitListe.addAll(isci.kaydet()));
        dbHandler.kaydet(kayitListe);

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

        public void goster(LocalDate tarih) {
            isim.setText(liste.get(getLayoutPosition()).ISIM);

            geldi.setChecked(liste.get(getLayoutPosition()).YOKLAMA.contains(tarih.toString()));
            odendi.setChecked(liste.get(getLayoutPosition()).ODEME.contains(tarih.toString()));

            geldi.setOnCheckedChangeListener((compoundButton, b) -> liste.get(getLayoutPosition()).yoklamaBtn(tarih, b));
            odendi.setOnCheckedChangeListener((compoundButton, b) -> liste.get(getLayoutPosition()).odemeBtn(tarih, b));
        }


    }
}
