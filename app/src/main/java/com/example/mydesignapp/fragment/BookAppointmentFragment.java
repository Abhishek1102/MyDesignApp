package com.example.mydesignapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydesignapp.R;
import com.example.mydesignapp.activity.MainActivity;
import com.example.mydesignapp.helper.Utils;


public class BookAppointmentFragment extends Fragment {

    View view;
    TextView tv_skip;
    ImageView iv_arrow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_book_appointment, container, false);
        tv_skip = view.findViewById(R.id.tv_skip);
        iv_arrow = view.findViewById(R.id.iv_arrow);

        Utils.blackIconStatusBar(getActivity(), R.color.white);

        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        iv_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                designfragment(new ConsultDoctorOnline(),"Consult Doctor Online");
            }
        });

        return view;
    }

    private void designfragment(Fragment fragment,String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.framelayout_design,fragment,tag).addToBackStack(null);
        fragmentTransaction.commit();
    }
}