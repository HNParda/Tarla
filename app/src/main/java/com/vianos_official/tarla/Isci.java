package com.vianos_official.tarla;

import java.time.LocalDate;
import java.util.ArrayList;

public class Isci {

    public int ID;
    public String ISIM;
    public ArrayList<LocalDate> yoklama;
    public ArrayList<LocalDate> odeme;

    public Isci () {
        yoklama = new ArrayList<>();
        odeme = new ArrayList<>();
    }
}
