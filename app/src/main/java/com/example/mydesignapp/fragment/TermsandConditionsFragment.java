package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydesignapp.R;


public class TermsandConditionsFragment extends Fragment {

    View view;
    ImageView iv_back;
    Button btn_accept, btn_decline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_termsand_conditions, container, false);
        iv_back = view.findViewById(R.id.iv_termsandconditionsBack);
        btn_accept = view.findViewById(R.id.btn_accept);
        btn_decline = view.findViewById(R.id.btn_decline);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("Terms and Conditions Fragment");
            }
        });

        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toast("info","Thank you for accepting it");
//              Toast.makeText(getContext(), "Thank you for accepting", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backpress("Terms and Conditions Fragment");
                    }
                }, 4000);
            }
        });

        btn_decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("warning","Please accept the terms and conditions");
//                backtohomefragment(new HomeFragment(), "Home Fragment");
            }
        });

        return view;
    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    private void backtohomefragment(Fragment fragment, String tag) {
        getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

    private void toast(String type,String desc) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, view.findViewById(R.id.lv_customtoast));
        ImageView iv_messageimage = layout.findViewById(R.id.iv_messageimage);
        TextView tv_messagetitle = layout.findViewById(R.id.tv_messagetitle);
        TextView tv_messagedesc = layout.findViewById(R.id.tv_messagedesc);
        LinearLayout lv_message = layout.findViewById(R.id.lv_message);

        if (type.equalsIgnoreCase("success"))//success
        {
            lv_message.setBackgroundColor(getResources().getColor(R.color.green2));
            iv_messageimage.setImageResource(R.drawable.check);
            tv_messagetitle.setText("Success");
            tv_messagedesc.setText(desc);
            tv_messagedesc.setText(desc);
        }
        else if (type.equalsIgnoreCase("info"))//info
        {
            lv_message.setBackgroundColor(getResources().getColor(R.color.blue));
            iv_messageimage.setImageResource(R.drawable.info);
            tv_messagetitle.setText("Info");
            tv_messagedesc.setText(desc);
            tv_messagedesc.setText(desc);
        }
        else if (type.equalsIgnoreCase("error")){
            lv_message.setBackgroundColor(getResources().getColor(R.color.red_2));
            iv_messageimage.setImageResource(R.drawable.danger);
            tv_messagetitle.setText("Danger");
            tv_messagedesc.setText(desc);
        }
        else if (type.equalsIgnoreCase("warning")){
            lv_message.setBackgroundColor(getResources().getColor(R.color.orange4));
            iv_messageimage.setImageResource(R.drawable.exclamation);
            tv_messagetitle.setText("Warning");
            tv_messagedesc.setText(desc);
        }


        Toast toast = new Toast(getActivity());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

}