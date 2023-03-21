package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mydesignapp.R;
import com.example.mydesignapp.model.DoctorSpecialityModelClass;
import com.example.mydesignapp.model.UserreviewModel;
import com.example.mydesignapp.helper.Utils;

import java.util.ArrayList;
import java.util.List;


public class DoctorProfileFragment extends Fragment {

    LinearLayout ll_about, ll_reviews;
    View view, view_about, view_reviews;
    TextView tv_about, tv_reviews, doctorprofilename, doctorprofiledescription, doctorprofilerating, doctorprofileratingnumber, doctorprofiledistance, tv_doctordecription, tv_doctorqualification, tv_doctorworkingtime, tv_doctoraddress, tv_username, tv_userreview, tv_userrating, tv_bookappointment;
    ImageView iv_back, doctorprofile_image, iv_userimage;
    DoctorSpecialityModelClass doctorSpecialityModelClass;
    RecyclerView rv_userreview;
    UserreviewModel userreviewModel;


    private List<UserreviewModel> userreviewModelList;
    private List<DoctorSpecialityModelClass> doctorSpecialityModelClassList;

    public DoctorProfileFragment(DoctorSpecialityModelClass doctorSpecialityModelClass) {
        this.doctorSpecialityModelClass = doctorSpecialityModelClass;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_doctor_profile, container, false);
        tv_about = view.findViewById(R.id.tv_about);
        ll_about = view.findViewById(R.id.ll_about);
        ll_reviews = view.findViewById(R.id.ll_reviews);
        tv_reviews = view.findViewById(R.id.tv_reviews);
        view_about = view.findViewById(R.id.view_about);
        view_reviews = view.findViewById(R.id.view_reviews);
        doctorprofilename = view.findViewById(R.id.doctorprofilename);
        iv_back = view.findViewById(R.id.iv_doctorprofileBack);
        doctorprofile_image = view.findViewById(R.id.doctorprofileimage);
        doctorprofiledescription = view.findViewById(R.id.doctorprofiledescription);
        doctorprofilerating = view.findViewById(R.id.doctorprofilerating);
        doctorprofileratingnumber = view.findViewById(R.id.doctorprofileratingnumber);
        doctorprofiledistance = view.findViewById(R.id.doctorprofiledistance);
        tv_doctordecription = view.findViewById(R.id.tv_doctordescription);
        tv_doctorqualification = view.findViewById(R.id.tv_doctorqualification);
        tv_doctorworkingtime = view.findViewById(R.id.tv_doctorworkingtime);
        tv_doctoraddress = view.findViewById(R.id.tv_doctoraddress);
        iv_userimage = view.findViewById(R.id.iv_userimage);
        tv_username = view.findViewById(R.id.tv_username);
        tv_userreview = view.findViewById(R.id.tv_userreview);
        tv_userrating = view.findViewById(R.id.tv_userrating);
        rv_userreview = view.findViewById(R.id.rv_userreview);
        tv_bookappointment = view.findViewById(R.id.tv_doctorprofileBookappointment);

        Utils.blackIconStatusBar(getActivity(), R.color.blue_app);


        doctorSpecialityModelClassList = new ArrayList<>();
        userreviewModelList = new ArrayList<>();


        doctorprofilename.setText(doctorSpecialityModelClass.getDoctorname());
        doctorprofile_image.setImageResource(doctorSpecialityModelClass.getDoctorimage());
        doctorprofiledescription.setText(doctorSpecialityModelClass.getDoctorSpeciality());
        doctorprofilerating.setText(doctorSpecialityModelClass.getDoctorRating());
        doctorprofileratingnumber.setText(doctorSpecialityModelClass.getDoctorRatingnumber());
        doctorprofiledistance.setText(doctorSpecialityModelClass.getDoctordistance());
        tv_doctordecription.setText(doctorSpecialityModelClass.getDoctor_description());
        tv_doctorqualification.setText(doctorSpecialityModelClass.getDoctor_qulification());
        tv_doctorworkingtime.setText(doctorSpecialityModelClass.getDoctor_workingtime());
        tv_doctoraddress.setText(doctorSpecialityModelClass.getDoctor_address());


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("HeartDiseaseFragment");
            }
        });

        //Doctor info About
//        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("",",",",",",","","",R.drawable.user_icon,"","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","M.B.B.S, F.C.P.S, Cardio Specialist","Mon-Fri, 09:00 AM - 08:00 PM",
//                "3533 Fittro Street\n" + "\n" + "City:  Murfreesboro\n" + "\n" + "State/province/area:   Arkansas",
//                "Tom Hank","Very Good Doctor",R.drawable.user_girl,""));
//        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("",",",",",",","","",R.drawable.user_icon,"","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","M.B.B.S, F.C.P.S, Cardio Specialist","Mon-Fri, 09:00 AM - 08:00 PM",
//                "3533 Fittro Street\n" + "\n" + "City:  Murfreesboro\n" + "\n" + "State/province/area:   Arkansas",
//                "Tom Hank","Very Good Doctor",R.drawable.user_girl,""));
//        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("",",",",",",","","",R.drawable.user_icon,"","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","M.B.B.S, F.C.P.S, Cardio Specialist","Mon-Fri, 09:00 AM - 08:00 PM",
//                "3533 Fittro Street\n" + "\n" + "City:  Murfreesboro\n" + "\n" + "State/province/area:   Arkansas",
//                "Tom Hank","Very Good Doctor",R.drawable.user_girl,""));


        view_about.setBackgroundColor(getResources().getColor(R.color.blue_app));
        view_reviews.setBackgroundColor(getResources().getColor(R.color.light_gray));
        ll_reviews.setVisibility(View.GONE);
        ll_about.setVisibility(View.VISIBLE);

        tv_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view_about.setBackgroundColor(getResources().getColor(R.color.blue_app));
                view_reviews.setBackgroundColor(getResources().getColor(R.color.light_gray));
                ll_reviews.setVisibility(View.GONE);
                ll_about.setVisibility(View.VISIBLE);
            }
        });

        tv_reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view_reviews.setBackgroundColor(getResources().getColor(R.color.blue_app));
                view_about.setBackgroundColor(getResources().getColor(R.color.light_gray));
                ll_about.setVisibility(View.GONE);
                ll_reviews.setVisibility(View.VISIBLE);
            }
        });

        tv_bookappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AppointmentScheduleFragment appointmentScheduleFragment = new AppointmentScheduleFragment(doctorSpecialityModelClass);
//                openfragment(appointmentScheduleFragment, "Appointment Schedule Fragment");

                //for taking data
//                PatientDetailsFragment patientDetailsFragment = new PatientDetailsFragment(doctorSpecialityModelClass);
//                openfragment(patientDetailsFragment,"Patient Details Fragment");
                AppointmentScheduleFragment appointmentScheduleFragment = new AppointmentScheduleFragment(doctorSpecialityModelClass);
                openfragment(appointmentScheduleFragment,"Appointment Schedule Fragment");
                Utils.blackIconStatusBar(getActivity(), R.color.white);
            }
        });

        userreviewModelList.add(new UserreviewModel("Tom Hanks", "Very Good Doctor,Very fine Gentleman", "4.5", R.drawable.user_icon));
        userreviewModelList.add(new UserreviewModel("Jimmy Singh", "Nice doctor knows it's work.\nVery Polite and honest", "4.0", R.drawable.user_girl));
        userreviewModelList.add(new UserreviewModel("Tom Hanks", "Very Good Doctor,Very fine Gentleman", "4.5", R.drawable.user_icon));
        userreviewModelList.add(new UserreviewModel("Jimmy Singh", "Nice doctor knows it's work.\nVery Polite and honest", "4.0", R.drawable.user_girl));

        UserreviewAdapter userreviewAdapter = new UserreviewAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rv_userreview.setLayoutManager(linearLayoutManager);
        rv_userreview.setAdapter(userreviewAdapter);

        return view;
    }

    class UserreviewAdapter extends RecyclerView.Adapter<UserreviewAdapter.userreviewholder> {
        @NonNull
        @Override
        public UserreviewAdapter.userreviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_userreview, parent, false);
            return new userreviewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UserreviewAdapter.userreviewholder holder, int position) {
            UserreviewModel userreviewModel = userreviewModelList.get(position);
            holder.iv_userimage.setImageResource(userreviewModel.getUserimage());
            holder.tv_username.setText(userreviewModel.getUsername());
            holder.tv_userreview.setText(userreviewModel.getUserreview());
            holder.tv_userrating.setText(userreviewModel.getUserrating());
        }

        @Override
        public int getItemCount() {
            return userreviewModelList.size();
        }

        public class userreviewholder extends RecyclerView.ViewHolder {
            ImageView iv_userimage;
            TextView tv_username, tv_userrating, tv_userreview;

            public userreviewholder(@NonNull View itemView) {
                super(itemView);
                iv_userimage = itemView.findViewById(R.id.iv_userimage);
                tv_username = itemView.findViewById(R.id.tv_username);
                tv_userrating = itemView.findViewById(R.id.tv_userrating);
                tv_userreview = itemView.findViewById(R.id.tv_userreview);
            }
        }
    }

    private void openfragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_doctorprofile, fragment, tag).addToBackStack(null);
        fragmentTransaction.commit();
        Utils.blackIconStatusBar(getActivity(), R.color.white);
    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
        Utils.blackIconStatusBar(getActivity(), R.color.white);
    }
}