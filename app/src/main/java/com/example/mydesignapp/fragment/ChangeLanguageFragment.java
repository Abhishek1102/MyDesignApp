package com.example.mydesignapp.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mydesignapp.R;
import com.example.mydesignapp.activity.SplashScreen;
import com.example.mydesignapp.helper.AppConstant;
import com.example.mydesignapp.helper.SecurePreferences;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ChangeLanguageFragment extends BottomSheetDialogFragment {
    View view;
    RelativeLayout rl_english, rl_gujarati;
    ImageView iv_english, iv_gujarati, iv_close;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_change_language, container, false);
        rl_english = view.findViewById(R.id.rl_english);
        rl_gujarati = view.findViewById(R.id.rl_gujarati);
        iv_english = view.findViewById(R.id.iv_english);
        iv_gujarati = view.findViewById(R.id.iv_gujarati);
        iv_close = view.findViewById(R.id.iv_closelanguagesheet);



        rl_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecurePreferences.saveLanguagePreferences(getActivity(), AppConstant.LANGUAGE, "en");
                AppConstant.setLanguage(getActivity());
                SecurePreferences.savePreferences(getActivity(), AppConstant.IS_LOGIN, true);
                getActivity().finishAffinity();
                Intent i = new Intent(getActivity(), SplashScreen.class);
                startActivity(i);
            }
        });

        rl_gujarati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecurePreferences.saveLanguagePreferences(getActivity(), AppConstant.LANGUAGE, "gu");
                AppConstant.setLanguage(getActivity());
                SecurePreferences.savePreferences(getActivity(), AppConstant.IS_LOGIN, true);
                getActivity().finishAffinity();
                Intent i = new Intent(getActivity(), SplashScreen.class);
                startActivity(i);
            }
        });

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        initView();
        return view;
    }


    void initView() {
        if (SecurePreferences.getLanguage(getActivity()).equalsIgnoreCase("en")) {
            iv_english.setVisibility(View.VISIBLE);
            iv_gujarati.setVisibility(View.GONE);
            SecurePreferences.saveLanguagePreferences(getActivity(), AppConstant.LANGUAGE, "en");
        } else if (SecurePreferences.getLanguage(getActivity()).equalsIgnoreCase("gu")) {
            iv_english.setVisibility(View.GONE);
            iv_gujarati.setVisibility(View.VISIBLE);
            SecurePreferences.saveLanguagePreferences(getActivity(), AppConstant.LANGUAGE, "gu");
        }
    }
}