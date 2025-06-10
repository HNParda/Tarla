package com.vianos_official.tarla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.gson.Gson;
import com.vianos_official.tarla.ui.MainActivity;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public static final String ID_COL = "id";
    public static final String YOKLAMA_COL = "yoklama";
    public static final String ODEME_COL = "odeme";
    private static final String DB_NAME = "Isciler.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Isciler";
    private static final String NAME_COL = "isim";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_COL + " TEXT," + YOKLAMA_COL + " TEXT," + ODEME_COL + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }


    public ArrayList<Isci> getIsciListe() {

        ArrayList<Isci> yeniListe = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, "isim ASC");

            if (cursor.moveToFirst()) {
                do {
                    int IdIndex = cursor.getColumnIndex(ID_COL);
                    int IsimIndex = cursor.getColumnIndex(NAME_COL);
                    int YoklamaIndex = cursor.getColumnIndex(YOKLAMA_COL);
                    int OdemeIndex = cursor.getColumnIndex(ODEME_COL);

                    int id = cursor.getInt(IdIndex);
                    String isim = cursor.getString(IsimIndex);
                    String yoklama = cursor.getString(YoklamaIndex);
                    String odeme = cursor.getString(OdemeIndex);

                    Isci isci = new Isci(id, isim, yoklama, odeme);
                    yeniListe.add(isci);
                } while (cursor.moveToNext());
            }
            db.close();
            cursor.close();
            return yeniListe;
        } catch (Exception e) {
            Log.e("testtest", "Error while trying to get posts from database\n" + e.getMessage());
            db.close();
            return new ArrayList<>();
        }


    }


    public void kaydet(ArrayList<Kayit> liste) {

        SQLiteDatabase db = this.getWritableDatabase();

        liste.forEach(kayit -> {
            ContentValues contentValues = new ContentValues();
            contentValues.put(kayit.anahtar, kayit.deger);
            db.update(TABLE_NAME, contentValues, "id = ?", new String[]{String.valueOf(kayit.ID)});
        });

        db.close();

    }

    public void isciEkle(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Gson gson = new Gson();
        String bos = gson.toJson(new ArrayList<>());
        values.put(NAME_COL, name);
        values.put(YOKLAMA_COL, bos);
        values.put(ODEME_COL, bos);
        db.insert(TABLE_NAME, null, values);
        db.close();
        MainActivity.liste = getIsciListe();
    }

    public void isciSil(int ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(ID)});
        db.close();
        MainActivity.liste = getIsciListe();
    }

    public void duzenle(int id, String name) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_COL, name);
        db.update(TABLE_NAME, contentValues, "id = ?", new String[]{String.valueOf(id)});

        db.close();
    }
}