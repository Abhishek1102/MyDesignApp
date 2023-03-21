package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mydesignapp.R;


public class ContactUsFragment extends Fragment {

    View view;
    Button btn_sendmessage;
    ImageView iv_back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        btn_sendmessage = view.findViewById(R.id.btn_sendmessage);
        iv_back = view.findViewById(R.id.iv_contactusback);

        btn_sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Your message has been sent", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backpress("Contactus Fragment");
                    }
                }, 3000);
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("Contactus Fragment");
            }
        });

        return view;
    }

    private void backpress(String tag){
        getActivity().getSupportFragmentManager().popBackStack();
    }
}