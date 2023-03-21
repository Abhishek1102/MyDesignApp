package com.example.mydesignapp.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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

import com.example.mydesignapp.model.AppointmentModelClass;
import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.Utils;

import java.util.ArrayList;
import java.util.List;


public class AppointmentFragment extends Fragment {

    View view;
    private RecyclerView rv_upcomingappointment, rv_pastappointment;
    private List<AppointmentModelClass> appointmentModelClasseslist;
    private TextView tv_upcoming, tv_past;
    private LinearLayout lv_upcomingappointment, lv_pastappointment;
    SharedPreferences sharedPreferences;
    AppointmentModelClass appointmentModelClass;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_appointment, container, false);
        Utils.blackIconStatusBar(getActivity(), R.color.white);

        rv_upcomingappointment = view.findViewById(R.id.rv_upcomingappointment);
        rv_pastappointment = view.findViewById(R.id.rv_pastappointment);
        tv_upcoming = view.findViewById(R.id.tv_upcoming);
        tv_past = view.findViewById(R.id.tv_past);
        lv_upcomingappointment = view.findViewById(R.id.lv_upcomingAppointment);
        lv_pastappointment = view.findViewById(R.id.lv_pastappointment);

        tv_upcoming.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_layout_blue_left));
        tv_past.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_layout_white_right));
        tv_upcoming.setTextColor(getResources().getColor(R.color.white));
        tv_past.setTextColor(getResources().getColor(R.color.blue_app));

        lv_upcomingappointment.setVisibility(View.VISIBLE);
        lv_pastappointment.setVisibility(View.GONE);

        tv_upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_upcoming.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_layout_blue_left));
                tv_past.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_layout_white_right));
                tv_upcoming.setTextColor(getResources().getColor(R.color.white));
                tv_past.setTextColor(getResources().getColor(R.color.blue_app));

                lv_upcomingappointment.setVisibility(View.VISIBLE);
                lv_pastappointment.setVisibility(View.GONE);
            }
        });

        tv_past.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_past.setTextColor(getResources().getColor(R.color.white));
                tv_upcoming.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_layout_white_left));
                tv_past.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.border_layout_blue_right));
                tv_upcoming.setTextColor(getResources().getColor(R.color.blue_app));

                lv_upcomingappointment.setVisibility(View.GONE);
                lv_pastappointment.setVisibility(View.VISIBLE);
            }
        });

        appointmentModelClasseslist = new ArrayList<>();

        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctor_image, "Dr.Raymond Martin", "145 Valencia St, San Francisco",
                "6:00", "PM", "11 Feb 2022", "Cardiologist", R.drawable.call_icon, ""));

        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "Dr.Sam Singh", "145 Rossenburg, Richard Street",
                "10:00", "AM", "20 Feb 2022", "M.B.B.S.", R.drawable.white_usericon, ""));

        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctor_image, "Dr.Jack Nicole", "105 Homles Street, Silicon Valley",
                "12:00", "PM", "23 Feb 2022", "M.D.", R.drawable.white_usericon, ""));

        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "Dr.Chris Jey", "145 Rossenburg, richard Street",
                "10:00", "AM", "26 Mar 2022", "Therapist", R.drawable.videocall_icon, ""));

        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "Dr.Chris Jey", "145 Rossenburg, richard Street",
                "10:00", "AM", "28 Mar 2022", "Physician", R.drawable.white_usericon, ""));


        // sharedPreferences = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);


        DoctorUpcomingAppointmentAdapter doctorUpcomingAppointmentAdapter = new DoctorUpcomingAppointmentAdapter(this, appointmentModelClasseslist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        DoctorPastAppointmentAdapter doctorPastAppointmentAdapter = new DoctorPastAppointmentAdapter(this, appointmentModelClasseslist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rv_pastappointment.setLayoutManager(linearLayoutManager);
        rv_pastappointment.setAdapter(doctorPastAppointmentAdapter);


        rv_upcomingappointment.setLayoutManager(layoutManager);
        rv_upcomingappointment.setAdapter(doctorUpcomingAppointmentAdapter);
        rv_upcomingappointment.scheduleLayoutAnimation();


//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.clear();
//                editor.commit();
//                Intent i = new Intent(getActivity(),LoginActivity.class);
//                startActivity(i);
//                getActivity().finish();
//            }
//        });

        return view;
    }

    class DoctorUpcomingAppointmentAdapter extends RecyclerView.Adapter<DoctorUpcomingAppointmentAdapter.appointmentholder> {


        public DoctorUpcomingAppointmentAdapter(AppointmentFragment appointmentFragment, List<AppointmentModelClass> appointmentModelClasseslist) {
        }

        @NonNull
        @Override
        public DoctorUpcomingAppointmentAdapter.appointmentholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_upcomingappointment, parent, false);
            return new DoctorUpcomingAppointmentAdapter.appointmentholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DoctorUpcomingAppointmentAdapter.appointmentholder holder, int position) {
            AppointmentModelClass appointmentModelClass = appointmentModelClasseslist.get(position);
            holder.tv_doctorname.setText(appointmentModelClass.getDoctorname());
            holder.iv_doctorimage.setImageResource(appointmentModelClass.getDoctorimage());
            holder.tv_doctoraddress.setText(appointmentModelClass.getDoctoraddress());
            holder.tv_doctortime.setText(appointmentModelClass.getDoctortime());
            holder.tv_doctortimeAmPm.setText(appointmentModelClass.getDoctortimeAmPm());
            holder.tv_upcomingappointmentdate.setText(appointmentModelClass.getDoctorappointmentdate());

        }

        @Override
        public int getItemCount() {
            return appointmentModelClasseslist.size();
        }

        public class appointmentholder extends RecyclerView.ViewHolder {
            ImageView iv_doctorimage;
            TextView tv_doctorname, tv_doctoraddress, tv_doctortime, tv_doctortimeAmPm, tv_upcomingappointmentdate;

            public appointmentholder(@NonNull View itemView) {
                super(itemView);

                iv_doctorimage = itemView.findViewById(R.id.iv_upcomingAppoinmentDoctorImage);
                tv_doctorname = itemView.findViewById(R.id.tv_upcomingAppointmentDoctorName);
                tv_doctoraddress = itemView.findViewById(R.id.tv_upcomingAppointmentDoctorAddress);
                tv_doctortime = itemView.findViewById(R.id.tv_upcomingAppointmentDoctorTime);
                tv_doctortimeAmPm = itemView.findViewById(R.id.tv_upcomingAppointmentDoctorTimeDayNight);
                tv_upcomingappointmentdate = itemView.findViewById(R.id.tv_upcomingAppointmentdate);

            }
        }
    }

    class DoctorPastAppointmentAdapter extends RecyclerView.Adapter<DoctorPastAppointmentAdapter.pastappointmentholder> {

        public DoctorPastAppointmentAdapter(AppointmentFragment appointmentFragment, List<AppointmentModelClass> appointmentModelClasseslist) {
        }

        @NonNull
        @Override
        public DoctorPastAppointmentAdapter.pastappointmentholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pastappointment, parent, false);
            return new DoctorPastAppointmentAdapter.pastappointmentholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DoctorPastAppointmentAdapter.pastappointmentholder holder, int position) {
            AppointmentModelClass appointmentModelClass = appointmentModelClasseslist.get(position);
            holder.iv_pastdoctorimage.setImageResource(appointmentModelClass.getDoctorimage());
            holder.iv_pastoptionicon.setImageResource(appointmentModelClass.getOptionicon_image());
            holder.tv_pastdoctorname.setText(appointmentModelClass.getDoctorname());
            holder.tv_pastdoctorspeciality.setText(appointmentModelClass.getDoctorspeciality());
            holder.tv_pastdoctoraddress.setText(appointmentModelClass.getDoctoraddress());
            holder.tv_pastdoctortime.setText(appointmentModelClass.getDoctortime());
            holder.tv_pastdoctortimeAmPm.setText(appointmentModelClass.getDoctortimeAmPm());
            holder.tv_pastappointmentdate.setText(appointmentModelClass.getDoctorappointmentdate());

            holder.tv_writereview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReviewFragment reviewFragment = new ReviewFragment(appointmentModelClass);
                    openfragment(reviewFragment, "Review Fragment");
                }
            });


        }

        @Override
        public int getItemCount() {
            return appointmentModelClasseslist.size();
        }

        public class pastappointmentholder extends RecyclerView.ViewHolder {
            ImageView iv_pastdoctorimage, iv_pastoptionicon;
            TextView tv_pastdoctorname, tv_pastdoctoraddress, tv_pastdoctortime, tv_pastdoctortimeAmPm, tv_pastappointmentdate, tv_pastdoctorspeciality, tv_writereview;

            public pastappointmentholder(@NonNull View itemView) {
                super(itemView);
                iv_pastdoctorimage = itemView.findViewById(R.id.iv_pastAppoinmentDoctorImage);
                iv_pastoptionicon = itemView.findViewById(R.id.iv_optionicon);
                tv_pastdoctorname = itemView.findViewById(R.id.tv_pastAppointmentDoctorName);
                tv_pastdoctorspeciality = itemView.findViewById(R.id.tv_pastappointmentSpeciality);
                tv_pastdoctoraddress = itemView.findViewById(R.id.tv_pastAppointmentDoctorAddress);
                tv_pastdoctortimeAmPm = itemView.findViewById(R.id.tv_pastAppointmentDoctorTimeDayNight);
                tv_pastappointmentdate = itemView.findViewById(R.id.tv_pastappointmentDate);
                tv_pastdoctortime = itemView.findViewById(R.id.tv_pastAppointmentDoctorTime);
                tv_writereview = itemView.findViewById(R.id.tv_writereview);

            }
        }
    }

    private void openfragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_full, fragment, tag).addToBackStack(null);
        fragmentTransaction.commit();
    }
}