package com.example.mydesignapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.mydesignapp.R;
import com.example.mydesignapp.activity.MainActivity;


public class ConsultDoctorOnline extends Fragment {

    View view;
    ImageView iv_arrow;
    LottieAnimationView lottieAnimationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_consult_doctor_online, container, false);
        iv_arrow = view.findViewById(R.id.iv_arrow);

        lottieAnimationView = view.findViewById(R.id.animation_view);
        lottieAnimationView.loop(false);
        lottieAnimationView.playAnimation();

        iv_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });


        return view;
    }


}