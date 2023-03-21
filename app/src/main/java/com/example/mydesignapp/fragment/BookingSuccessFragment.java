package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.Utils;
import com.example.mydesignapp.model.DoctorSpecialityModelClass;

import pl.droidsonroids.gif.GifImageView;


public class BookingSuccessFragment extends Fragment {

    View view;
    ImageView iv_doctorimage;
    TextView tv_doctorname, tv_doctorspeciality, tv_appointmentdate, tv_appointmentid, tv_appointmenttype, tv_appointmentcharge, tv_appointmenttime;
    Button btn_home;
    DoctorSpecialityModelClass doctorSpecialityModelClass;
    GifImageView success;


    public BookingSuccessFragment(DoctorSpecialityModelClass doctorSpecialityModelClass) {
        this.doctorSpecialityModelClass = doctorSpecialityModelClass;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_booking_success, container, false);
        iv_doctorimage = view.findViewById(R.id.iv_bookingsuccessDcotorImage);
        tv_doctorname = view.findViewById(R.id.tv_bookingsuccessdoctorname);
        tv_doctorspeciality = view.findViewById(R.id.tv_bookingsuccessdoctorspeciality);
        tv_appointmentid = view.findViewById(R.id.tv_bookingsuccessappointmentId);
        tv_appointmentdate = view.findViewById(R.id.tv_bookingsuccessappointmentdate);
        tv_appointmenttype = view.findViewById(R.id.tv_bookingsuccessappointmentType);
        tv_appointmenttime = view.findViewById(R.id.tv_bookingsuccessappointmenttime);
        tv_appointmentcharge = view.findViewById(R.id.tv_bookingsuccessappointmenCharge);
        btn_home = view.findViewById(R.id.btn_home);
        success = view.findViewById(R.id.success_gif);


        Utils.blackIconStatusBar(getActivity(), R.color.white);
        success.setVisibility(View.VISIBLE);

        iv_doctorimage.setImageResource(doctorSpecialityModelClass.getDoctorimage());
        tv_doctorname.setText(doctorSpecialityModelClass.getDoctorname());
        tv_doctorspeciality.setText(doctorSpecialityModelClass.getDoctorSpeciality());
        tv_appointmentdate.setText(doctorSpecialityModelClass.getAppointmentDate());
        tv_appointmenttime.setText(doctorSpecialityModelClass.getAppointmentTime());
        tv_appointmentid.setText(doctorSpecialityModelClass.getAppointmentId());
        tv_appointmenttype.setText(doctorSpecialityModelClass.getAppointmentType());
        tv_appointmentcharge.setText(doctorSpecialityModelClass.getAppointmentCharge());


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtohomefragment(new HomeFragment(), "Home Fragment");

            }
        });

        return view;
    }

    //return to main home fragment
//    FragmentManager fm = getActivity().getSupportFragmentManager();
// for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
//        fm.popBackStack();
//    }
    private void backtohomefragment(Fragment fragment, String tag) {
        getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Utils.blackIconStatusBar(getActivity(), R.color.white);

    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();

    }
}