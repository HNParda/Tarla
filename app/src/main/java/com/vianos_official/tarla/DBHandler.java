package com.vianos_official.tarla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "/Isciler.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Isciler";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "isim";
    private static final String YOKLAMA_COL = "yoklama";
    private static final String ODEME_COL = "odemee";

    public DBHandler(Context context) {
        super(context, context.getDataDir().getPath() + DB_NAME, null, DB_VERSION);
        Log.e("testtest", context.getDataDir().getPath() + DB_NAME);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_COL + " TEXT," + YOKLAMA_COL + " TEXT," + ODEME_COL + " TEXT)";
        db.execSQL(query);
    }

    public void addNewCourse(String courseName, String courseDuration, String courseDescription) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, courseName);
        values.put(YOKLAMA_COL, courseDescription);
        values.put(ODEME_COL, courseDuration);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Isci> getIsciListe() {

        ArrayList<Isci> liste = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        try {
        Cursor cursor = db.rawQuery("SELECT * FROM Isciler", null);
            if (cursor.moveToFirst()) {
                do {
                    int IdIndex = cursor.getColumnIndex(ID_COL);
                    int IsimIndex = cursor.getColumnIndex(ID_COL);
                    int YoklamaIndex = cursor.getColumnIndex(ID_COL);
                    int OdemeIndex = cursor.getColumnIndex(ID_COL);

                    int id = cursor.getInt(IdIndex);
                    String isim = cursor.getString(IsimIndex);
                    String yoklama = cursor.getString(YoklamaIndex);
                    String odeme = cursor.getString(OdemeIndex);

                    Isci isci = new Isci(id, isim, new ArrayList<LocalDate>(), new ArrayList<LocalDate>());
                    liste.add(isci);
                } while (cursor.moveToNext());
            }
            db.close();
            return liste;
        } catch (Exception e) {
            Log.d("testtest", "Error while trying to get posts from database\n" + e.getMessage());
            db.close();
            return new ArrayList<>();
        }


    }
}