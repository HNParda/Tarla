package com.vianos_official.tarla.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vianos_official.tarla.DBHandler;
import com.vianos_official.tarla.Isci;
import com.vianos_official.tarla.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static DBHandler dbHandler;
    public static ArrayList<Isci> liste;
    public static boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHandler = new DBHandler(this);
        liste = dbHandler.getIsciListe();
        loaded = true;

        Log.e("testtest", "list tamam");

        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_yoklama, R.id.navigation_notlar, R.id.navigation_kisiler).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }


}