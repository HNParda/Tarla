package com.vianos_official.tarla;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

public class Isci {

    public int ID;
    public String ISIM;
    public String YOKLAMA_STRING;
    public String ODEME_STRING;
    public ArrayList<String> YOKLAMA;
    public ArrayList<String> ODEME;

    public Isci(int id, String isim, String yoklama, String odeme) {
        Log.e("testtest 1", String.valueOf(id));
        Log.e("testtest 2", isim);
        Log.e("testtest 3", yoklama);
        Log.e("testtest 4", odeme);
        this.ID = id;
        this.ISIM = isim;
        this.YOKLAMA_STRING = yoklama;
        this.ODEME_STRING = odeme;

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();

        YOKLAMA = gson.fromJson(yoklama, listType);
        ODEME = gson.fromJson(odeme, listType);

    }

    public void yoklamaBtn(LocalDate tarih, boolean geldi) {
        if (geldi) YOKLAMA.add(tarih.toString());
        else YOKLAMA.remove(tarih.toString());
    }

    public void odemeBtn(LocalDate tarih, boolean odendi) {
        if (odendi) ODEME.add(tarih.toString());
        else ODEME.remove(tarih.toString());
    }

    public ArrayList<Kayit> kaydet() {

        Gson gson = new Gson();
        String yoklama_string = gson.toJson(YOKLAMA);
        String odeme_string = gson.toJson(ODEME);

        ArrayList<Kayit> map = new ArrayList<>();
        if (yoklama_string != YOKLAMA_STRING) map.add(new Kayit(ID, DBHandler.YOKLAMA_COL, yoklama_string));
        if (odeme_string != ODEME_STRING) map.add(new Kayit(ID, DBHandler.ODEME_COL, odeme_string));

        return map;
    }
}
