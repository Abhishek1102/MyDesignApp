package com.example.mydesignapp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.Utils;
import com.example.mydesignapp.model.DoctorSpecialityModelClass;

public class PatientDetailsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    View view;
    EditText edt_patientname, edt_patientage, edt_patientphonenumber, edt_patientproblem;
    Button btn_continue;
    Spinner spinner_gender;
    ImageView iv_back;
    String patientname, patientage, patientgender, patientphonenumber, patientproblem;
    //for taking data
    DoctorSpecialityModelClass doctorSpecialityModelClass;
    SharedPreferences sharedPreferences;
    RelativeLayout rl_loadingpanel;

    String[] gender = {"Male","Female"};

    //for taking data
    PatientDetailsFragment(DoctorSpecialityModelClass doctorSpecialityModelClass) {
        this.doctorSpecialityModelClass = doctorSpecialityModelClass;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_patient_details, container, false);
        edt_patientname = view.findViewById(R.id.edt_patientname);
        edt_patientage = view.findViewById(R.id.edt_patientage);
        spinner_gender = view.findViewById(R.id.spinner_gender);
        edt_patientphonenumber = view.findViewById(R.id.edt_patientmobilenumber);
        edt_patientproblem = view.findViewById(R.id.edt_patientproblem);
        btn_continue = view.findViewById(R.id.btn_patientcontinue);
        iv_back = view.findViewById(R.id.iv_patientdetailsback);
        rl_loadingpanel = view.findViewById(R.id.rl_loadingpanel);

        spinner_gender.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,gender);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(arrayAdapter);

        Utils.blackIconStatusBar(getActivity(), R.color.white);


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("Patient Details");
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_patientname.getText().toString().isEmpty()) {
                    edt_patientname.setError("Required");
                    edt_patientname.requestFocus();
                } else if (edt_patientage.getText().toString().isEmpty()) {
                    edt_patientage.setError("Required");
                    edt_patientage.requestFocus();
                }  else if (edt_patientphonenumber.getText().toString().isEmpty()) {
                    edt_patientphonenumber.setError("Required");
                    edt_patientphonenumber.requestFocus();
                } else if (edt_patientproblem.getText().toString().isEmpty()) {
                    edt_patientproblem.setError("Required");
                    edt_patientproblem.requestFocus();
                }
                else {
                    validatadata();
                    OrderSummaryFragment orderSummaryFragment = new OrderSummaryFragment(doctorSpecialityModelClass);
                    openfragment(orderSummaryFragment, "Order Summary Fragment");

                }

            }
        });

        return view;
    }

    private void validatadata() {
        patientname = edt_patientname.getText().toString();
        patientage = edt_patientage.getText().toString();
        patientphonenumber = edt_patientphonenumber.getText().toString();
        patientproblem = edt_patientproblem.getText().toString();

        sharedPreferences = getActivity().getSharedPreferences("patient_details", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("patient_name", patientname);
        editor.apply();
    }

    private void openfragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_patientdetails, fragment, tag).addToBackStack(null);
        fragmentTransaction.commit();
        Utils.blackIconStatusBar(getActivity(), R.color.white);
    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        patientgender = gender[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}