package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.AppConstant;
import com.example.mydesignapp.helper.SecurePreferences;

public class MyProfileFragment extends Fragment {

    View view;
    ImageView iv_back;
    TextView tv_profilename,tv_profileusername,tv_myprofileusernumber,tv_myprofileuseremail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        iv_back = view.findViewById(R.id.iv_myprofileBack);
        tv_profilename = view.findViewById(R.id.tv_myprofilename);
        tv_profileusername = view.findViewById(R.id.tv_myprofileusername);
        tv_myprofileusernumber = view.findViewById(R.id.tv_myprofileusernumber);
        tv_myprofileuseremail = view.findViewById(R.id.tv_myprofileuseremail);

        tv_profilename.setText(SecurePreferences.getStringPreference(getActivity(), AppConstant.user_name));
        tv_myprofileusernumber.setText(SecurePreferences.getStringPreference(getActivity(), AppConstant.user_number));
        tv_myprofileuseremail.setText(SecurePreferences.getStringPreference(getActivity(),AppConstant.user_email));

        tv_profileusername.setText(tv_profilename.getText().toString().trim());

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress();
            }
        });
        return view;
    }

    private void backpress(){
        getActivity().getSupportFragmentManager().popBackStack();
    }
}