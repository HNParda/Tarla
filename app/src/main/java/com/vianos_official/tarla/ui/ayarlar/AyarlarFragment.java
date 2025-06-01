package com.vianos_official.tarla.ui.ayarlar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vianos_official.tarla.R;
import com.vianos_official.tarla.databinding.FragmentNotificationsBinding;

public class AyarlarFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}