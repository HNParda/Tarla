package com.vianos_official.tarla.ui.fragments.yoklama;


import static com.vianos_official.tarla.ui.MainActivity.loaded;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vianos_official.tarla.R;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class YoklamaFragment extends Fragment {
    YoklamaAdapter adapter;
    LinearLayout gunSec;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_yoklama, container, false);
        if (!loaded) return view;
        RecyclerView listeLayout = view.findViewById(R.id.list);
        adapter = new YoklamaAdapter();
        listeLayout.setAdapter(adapter);
        listeLayout.setLayoutManager(new LinearLayoutManager(inflater.getContext()));

        gunSec = view.findViewById(R.id.gunSec);
        gunSec.setOnClickListener(this::gunSec);
        view.findViewById(R.id.oncekiGun).setOnClickListener(this::oncekiGun);
        view.findViewById(R.id.sonrakiGun).setOnClickListener(this::sonrakiGun);

        gunGoster(adapter.date);


        return view;
    }

    private void oncekiGun(View view) {
        adapter.oncekiGun();
        gunGoster(adapter.date);

    }

    public void gunSec(View view) {

        LocalDate eskiTarih = adapter.date;
        int eskiGun = eskiTarih.getDayOfMonth();
        int eskiAy = eskiTarih.getMonthValue();
        int eskiYil = eskiTarih.getYear();

        DatePickerDialog.OnDateSetListener listener = (datePicker, year, month, day) -> {
            LocalDate yeniTarih = LocalDate.of(year, month, day);
            adapter.tarihDegistir(yeniTarih);
            gunGoster(yeniTarih);
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), listener, eskiYil, eskiAy, eskiGun);
        datePickerDialog.show();
    }

    private void sonrakiGun(View view) {
        adapter.sonrakiGun();
        gunGoster(adapter.date);
    }

    public void gunGoster(LocalDate gun) {
        TextView tarih = gunSec.findViewById(R.id.tarih);
        TextView haftaGun = gunSec.findViewById(R.id.gun);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        tarih.setText(gun.format(formatter));

        String trGun = gun.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        haftaGun.setText(trGun);

    }

    @Override
    public void onPause() {
        super.onPause();
        if (!loaded) return;
        adapter.kaydet();
    }


}