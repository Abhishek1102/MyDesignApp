package com.example.mydesignapp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.Utils;
import com.example.mydesignapp.model.DoctorSpecialityModelClass;

public class OrderSummaryFragment extends Fragment {

    View view;
    TextView tv_doctorname, tv_doctorspeciality, tv_patientname, tv_appointmentdate, tv_appointmenttime, tv_appointmenttype,
            tv_appointmentaddress, tv_appointmentid;
    Button btn_paynow;
    ImageView iv_doctorimage,iv_back;
    SharedPreferences sharedPreferences;
    //for taking data
    DoctorSpecialityModelClass doctorSpecialityModelClass;
    RelativeLayout rl_loadingpanel;

    //for taking data
    OrderSummaryFragment(DoctorSpecialityModelClass doctorSpecialityModelClass) {
        this.doctorSpecialityModelClass = doctorSpecialityModelClass;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order_summary, container, false);
        tv_doctorname = view.findViewById(R.id.tv_doctorname);
        tv_doctorspeciality = view.findViewById(R.id.tv_doctorspecilaity);
        iv_doctorimage = view.findViewById(R.id.iv_doctorimage);
        tv_patientname = view.findViewById(R.id.tv_patientname);
        tv_appointmenttime = view.findViewById(R.id.tv_appointmenttime);
        tv_appointmentdate = view.findViewById(R.id.tv_appointmentdate);
        tv_appointmenttype = view.findViewById(R.id.tv_appointmenttype);
        tv_appointmentaddress = view.findViewById(R.id.tv_AppointmentDoctorAddress);
        tv_appointmentid = view.findViewById(R.id.tv_appointmentid);
        btn_paynow = view.findViewById(R.id.btn_paynow);
        iv_back = view.findViewById(R.id.iv_ordersummaryback);
        rl_loadingpanel = view.findViewById(R.id.rl_loadingpanel);

        Utils.blackIconStatusBar(getActivity(), R.color.white);


        tv_doctorname.setText(doctorSpecialityModelClass.getDoctorname());
        tv_doctorspeciality.setText(doctorSpecialityModelClass.getDoctorSpeciality());
        iv_doctorimage.setImageResource(doctorSpecialityModelClass.getDoctorimage());
        tv_appointmentaddress.setText(doctorSpecialityModelClass.getDoctor_address());
        tv_appointmenttype.setText(doctorSpecialityModelClass.getAppointmentType());
        tv_appointmenttime.setText(doctorSpecialityModelClass.getAppointmentTime());
        tv_appointmentdate.setText(doctorSpecialityModelClass.getAppointmentDate());
        tv_appointmentid.setText(doctorSpecialityModelClass.getAppointmentId());


        sharedPreferences = getActivity().getSharedPreferences("patient_details", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("patient_name", "");
        tv_patientname.setText(name);

        btn_paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookingSuccessFragment bookingSuccessFragment = new BookingSuccessFragment(doctorSpecialityModelClass);
                rl_loadingpanel.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rl_loadingpanel.setVisibility(View.GONE);
                        openfragment(bookingSuccessFragment, "Booking Success Fragment");
                    }
                }, 5000);


            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("Order Summary");
            }
        });

        return view;
    }

    private void openfragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_ordersummary, fragment, tag).addToBackStack(null);
        fragmentTransaction.commit();
        Utils.blackIconStatusBar(getActivity(), R.color.white);
    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
    }
}