package com.vianos_official.tarla.ui.notlar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vianos_official.tarla.DBHandler;
import com.vianos_official.tarla.R;

public class NotlarFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notlar, container, false);

        DBHandler dbHandler = new DBHandler(view.getContext());
        dbHandler.addNewCourse("fas", "fas", "fas");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}