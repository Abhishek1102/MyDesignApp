package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mydesignapp.R;


public class SettingsFragment extends Fragment {


    View view;
    ImageView iv_back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        iv_back = view.findViewById(R.id.iv_settingsBack);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("Settings Fragment");
            }
        });

        return view;
    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
    }

}