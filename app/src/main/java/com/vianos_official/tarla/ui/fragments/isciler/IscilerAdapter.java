package com.vianos_official.tarla.ui.fragments.isciler;

import static com.vianos_official.tarla.ui.MainActivity.dbHandler;
import static com.vianos_official.tarla.ui.MainActivity.liste;

import android.content.Context;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

        holder.silBtn.setOnClickListener(view -> sil(view.getContext(), position));
        holder.duzenleBtn.setOnClickListener(view -> duzenle(view.getContext(), position));

    }

    private void sil(Context context, int index) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("İsim gir");

        final TextView warning = new TextView(context);
        warning.setPadding(50, 40, 50, 40);
        warning.setText("dsadsada dsadas");
        builder.setView(warning);

        builder.setPositiveButton("OK", (dialog, which) -> {
            int ID = liste.get(index).ID;
            liste.remove(index);
            dbHandler.isciSil(ID);
            notifyItemRemoved(index);

        });

        builder.setNegativeButton("İptal", (dialog, which) -> dialog.cancel());

        builder.show();

    }

    private void duzenle(Context context, int index) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("İsim düzenle");

        final EditText input = new EditText(context);
        input.setHint("İsim");
        input.setText(liste.get(index).ISIM);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setPadding(50, 40, 50, 40);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String name = input.getText().toString().trim();
            if (!name.isEmpty()) {
                int ID = liste.get(index).ID;
                liste.get(index).ISIM = name;
                dbHandler.duzenle(ID, name);
                notifyItemChanged(index);
            } else {
                Toast.makeText(context, "İsim boş olamaz", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("İptal", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }


    public static class IscilerViewHolder extends RecyclerView.ViewHolder {

        View kisi;
        TextView isim;
        FloatingActionButton duzenleBtn;
        FloatingActionButton silBtn;

        public IscilerViewHolder(@NonNull View view) {
            super(view);

            kisi = view;

            isim = kisi.findViewById(R.id.isim);
            duzenleBtn = kisi.findViewById(R.id.duzenleBtn);
            silBtn = kisi.findViewById(R.id.silBtn);

        }

        public void goster(Isci isci) {
            isim.setText(isci.ISIM);
        }

    }
}
