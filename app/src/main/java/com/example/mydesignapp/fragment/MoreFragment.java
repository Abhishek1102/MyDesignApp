package com.example.mydesignapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mydesignapp.R;
import com.example.mydesignapp.activity.LoginActivity;
import com.example.mydesignapp.helper.SecurePreferences;

public class MoreFragment extends Fragment {

    View view;
    LinearLayout lv_myprofile,lv_settings,lv_contactus,lv_termsandconditions,lv_faq,lv_logout,lv_changelanguage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_more, container, false);
        lv_myprofile = view.findViewById(R.id.lv_myprofile);
        lv_settings = view.findViewById(R.id.lv_settings);
        lv_contactus = view.findViewById(R.id.lv_contactus);
        lv_termsandconditions = view.findViewById(R.id.lv_termsandconditions);
        lv_faq = view.findViewById(R.id.lv_faq);
        lv_logout = view.findViewById(R.id.lv_logout);
        lv_changelanguage = view.findViewById(R.id.lv_changelanguage);
        SharedPreferences sharedPreferences;

        sharedPreferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);

        lv_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewallfragment(new SettingsFragment(),"Settings Fragment");
            }
        });

        lv_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewallfragment(new MyProfileFragment(),"My Profile Fragment");
            }
        });

        lv_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewallfragment(new ContactUsFragment(),"Contactus Fragment");
            }
        });

        lv_termsandconditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewallfragment(new TermsandConditionsFragment(),"Terms and Conditions");
            }
        });

        lv_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewallfragment(new FaqFragment(),"Faq Fragment");
            }
        });
        
        lv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                SecurePreferences.clearSecurepreference(getActivity());
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        lv_changelanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLanguageFragment changeLanguageFragment = new ChangeLanguageFragment();
                changeLanguageFragment.show(getActivity().getSupportFragmentManager(), "Change Language Fragment");
            }
        });

        return view;
    }

    private void viewallfragment(Fragment fragment,String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_full,fragment,tag).addToBackStack(null);
        fragmentTransaction.commit();
    }
}