package com.vianos_official.tarla;

import java.time.LocalDate;
import java.util.ArrayList;

public class Isci {

    public int ID;
    public String ISIM;
    public ArrayList<LocalDate> YOKLAMA;
    public ArrayList<LocalDate> ODEME;

    public Isci(int id, String isim, ArrayList<LocalDate> yoklama, ArrayList<LocalDate> odeme) {
        this.ID = id;
        this.ISIM = isim;
        this.YOKLAMA = yoklama;
        this.ODEME = odeme;
    }
}
