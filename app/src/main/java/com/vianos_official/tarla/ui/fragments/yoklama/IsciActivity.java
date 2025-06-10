package com.vianos_official.tarla.ui.fragments.yoklama;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vianos_official.tarla.Isci;
import com.vianos_official.tarla.R;
import com.vianos_official.tarla.ui.MainActivity;

public class IsciActivity extends AppCompatActivity {

    Isci isci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isci);

        int index = getIntent().getIntExtra("isci_index", 0);
        isci = MainActivity.liste.get(index);

        TextView isim = findViewById(R.id.isim);
        isim.setText(isci.ISIM);

        CalendarView takvim = findViewById(R.id.takvim);
        takvim.show(isci.YOKLAMA, isci.ODEME);


    }


}
