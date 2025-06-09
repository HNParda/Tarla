package com.vianos_official.tarla.ui.fragments.isciler;

import static com.vianos_official.tarla.ui.MainActivity.liste;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vianos_official.tarla.Isci;
import com.vianos_official.tarla.R;

import java.time.LocalDate;

public class IscilerAdapter extends RecyclerView.Adapter<IscilerAdapter.IscilerViewHolder> {

    LocalDate date = LocalDate.now();

    public IscilerAdapter() {
    }


    @NonNull
    @Override
    public IscilerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.liste_isciler, parent, false);
        return new IscilerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IscilerViewHolder holder, int position) {
        holder.goster(liste.get(position));
    }


    @Override
    public int getItemCount() {
        return liste.size();
    }


    public static class IscilerViewHolder extends RecyclerView.ViewHolder {

        View kisi;
        TextView isim;
        TextView id;
        LinearLayout duzenle;

        public IscilerViewHolder(@NonNull View view) {
            super(view);

            kisi = view;

            isim = kisi.findViewById(R.id.isim);
            id = kisi.findViewById(R.id.id);
            duzenle = kisi.findViewById(R.id.duzenleBtn);

        }

        public void goster(Isci isci) {
            isim.setText(isci.ISIM);
            id.setText(String.format("#%d", isci.ID));

            duzenle.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), IsciActivity.class);
                intent.putExtra("kisi_id", getAdapterPosition());
                view.getContext().startActivity(intent);
            });
        }
    }
}
