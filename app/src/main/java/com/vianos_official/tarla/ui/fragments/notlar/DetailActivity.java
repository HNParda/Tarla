package com.vianos_official.tarla.ui.fragments.notlar;

import static com.vianos_official.tarla.ui.fragments.notlar.NotlarFragment.notlar;
import static com.vianos_official.tarla.ui.fragments.notlar.NotlarFragment.sharedPreferences;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vianos_official.tarla.R;

public class DetailActivity extends AppCompatActivity {

    EditText not;
    String isim;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        not = findViewById(R.id.detailTextView);
        TextView notIsim = findViewById(R.id.Data_Notes);

        // Get the data passed from MainActivity
        index = getIntent().getIntExtra("NOT", 0);
        isim = notlar.get(index).notIsim;
        String icerik = notlar.get(index).notIcerik;

        notIsim.setText(isim);
        not.setText(icerik);
    }


    @Override
    public void onPause() {
        super.onPause();
        String yeniNot = not.getEditableText().toString();
        notlar.get(index).notIcerik = yeniNot;
        sharedPreferences.edit().putString(isim, yeniNot).apply();
    }

}