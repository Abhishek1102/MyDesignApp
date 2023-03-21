package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydesignapp.model.AppointmentModelClass;
import com.example.mydesignapp.R;

import java.util.ArrayList;
import java.util.List;


public class ReviewFragment extends Fragment {

    ImageView iv_reviewback,iv_reviewdoctorimage;
    TextView tv_reviewdoctorname;
    Button btn_reviewsubmit;
    View view;
    AppointmentModelClass appointmentModelClass;
    RatingBar ratingBar;

    private List<AppointmentModelClass> appointmentModelClassList;

    public ReviewFragment(AppointmentModelClass appointmentModelClass){
        this.appointmentModelClass = appointmentModelClass;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_review, container, false);

        iv_reviewback = view.findViewById(R.id.iv_reviewBack);
        iv_reviewdoctorimage = view.findViewById(R.id.iv_reviewDoctorimage);
        tv_reviewdoctorname = view.findViewById(R.id.tv_reviewdoctorname);
        btn_reviewsubmit = view.findViewById(R.id.btn_reviewsubmit);
        ratingBar = view.findViewById(R.id.ratingbar);

        ratingBar.setRating(3);

        appointmentModelClassList = new ArrayList<>();

        iv_reviewdoctorimage.setImageResource(appointmentModelClass.getDoctorimage());
        tv_reviewdoctorname.setText(appointmentModelClass.getDoctorname());

        btn_reviewsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Review Submitted", Toast.LENGTH_SHORT).show();
            }
        });

        iv_reviewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress();
            }
        });

        return view;
    }

    private void backpress() {
        getActivity().getSupportFragmentManager().popBackStack();
    }
}