package com.vianos_official.tarla.ui.fragments.notlar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vianos_official.tarla.R;

public class DetailActivity extends AppCompatActivity {

    EditText not;
    String isim;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        sharedPreferences = getSharedPreferences("notlar", MODE_PRIVATE);

        not = findViewById(R.id.detailTextView);
        TextView notIsim = findViewById(R.id.Data_Notes);

        // Get the data passed from MainActivity
        isim = getIntent().getStringExtra("ITEM");
        String icerik = getIntent().getStringExtra("CONTENT");

        notIsim.setText(isim);
        not.setText(icerik);
    }


    @Override
    public void onPause() {
        super.onPause();
        sharedPreferences.edit().putString(isim, not.getText().toString()).apply();
    }

}