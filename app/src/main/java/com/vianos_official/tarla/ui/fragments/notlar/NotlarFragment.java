package com.vianos_official.tarla.ui.fragments.notlar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vianos_official.tarla.R;

public class NotlarFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notlar, container, false);

        Log.e("testtest", "eklendi");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}