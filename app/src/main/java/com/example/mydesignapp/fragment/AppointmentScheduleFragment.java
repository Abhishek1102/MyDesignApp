package com.example.mydesignapp.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mydesignapp.model.AppointmentModelClass;
import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.Utils;
import com.example.mydesignapp.model.DoctorSpecialityModelClass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentScheduleFragment extends Fragment {

    View view, view_one, view_two, view_three, view_four, view_five;
    ImageView iv_back, iv_doctorimage,calender_icon;
    TextView tv_doctorname, tv_doctorspeciality, tv_doctorrating, tv_doctorreview, tv_one, tv_two, tv_three, tv_four, tv_five;
    RecyclerView rv_morningslot, rv_eveningslot;
    Button btn_continue;
    LinearLayout lv_one, lv_two, lv_three, lv_four, lv_five;
    DoctorSpecialityModelClass doctorSpecialityModelClass;
    private List<DoctorSpecialityModelClass> doctorSpecialityModelClassList;
    private List<AppointmentModelClass> appointmentmodelclasslistmorning;
    private List<AppointmentModelClass> appointmentmodelclasslistevening;
    final Calendar myCalendar= Calendar.getInstance();


    public AppointmentScheduleFragment(DoctorSpecialityModelClass doctorSpecialityModelClass) {
        this.doctorSpecialityModelClass = doctorSpecialityModelClass;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_appointment_schedule, container, false);
        iv_back = view.findViewById(R.id.iv_bookingscheduleBack);
        iv_doctorimage = view.findViewById(R.id.iv_bookingscheduleDoctorimage);
        tv_doctorname = view.findViewById(R.id.tv_bookingscheduleDoctorname);
        tv_doctorspeciality = view.findViewById(R.id.tv_bookingscheduleDoctorspeciality);
        tv_doctorrating = view.findViewById(R.id.tv_bookingscheduledoctorrating);
        tv_doctorreview = view.findViewById(R.id.tv_bookingscheduledoctorreviews);
        rv_eveningslot = view.findViewById(R.id.rv_eveningslot);
        rv_morningslot = view.findViewById(R.id.rv_morningslot);
        lv_one = view.findViewById(R.id.lv_one);
        lv_two = view.findViewById(R.id.lv_two);
        lv_three = view.findViewById(R.id.lv_three);
        lv_four = view.findViewById(R.id.lv_four);
        lv_five = view.findViewById(R.id.lv_five);
        view_one = view.findViewById(R.id.view_one);
        view_two = view.findViewById(R.id.view_two);
        view_three = view.findViewById(R.id.view_three);
        view_four = view.findViewById(R.id.view_four);
        view_five = view.findViewById(R.id.view_five);
        tv_one = view.findViewById(R.id.tv_one);
        tv_two = view.findViewById(R.id.tv_two);
        tv_three = view.findViewById(R.id.tv_three);
        tv_four = view.findViewById(R.id.tv_four);
        tv_five = view.findViewById(R.id.tv_five);
        btn_continue = view.findViewById(R.id.btn_continue);
        calender_icon = view.findViewById(R.id.calendericon);


        Utils.blackIconStatusBar(getActivity(), R.color.white);

        doctorSpecialityModelClassList = new ArrayList<>();
        appointmentmodelclasslistmorning = new ArrayList<>();
        appointmentmodelclasslistevening = new ArrayList<>();

        tv_doctorname.setText(doctorSpecialityModelClass.getDoctorname());
        iv_doctorimage.setImageResource(doctorSpecialityModelClass.getDoctorimage());
        tv_doctorspeciality.setText(doctorSpecialityModelClass.getDoctorSpeciality());
        tv_doctorreview.setText(doctorSpecialityModelClass.getDoctorRatingnumber());
        tv_doctorrating.setText(doctorSpecialityModelClass.getDoctorRating());

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("Appointment Schedule Fragment");
            }
        });

        appointmentmodelclasslistmorning.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "09:00 AM"));
        appointmentmodelclasslistmorning.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "09:15 AM"));
        appointmentmodelclasslistmorning.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "09:30 AM"));
        appointmentmodelclasslistmorning.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "09:45 AM"));
        appointmentmodelclasslistmorning.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "10:30 AM"));
        appointmentmodelclasslistmorning.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "11:00 AM"));


        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "03:00 PM"));
        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "03:30 PM"));
        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "04:00 PM"));
        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "04:45 PM"));
        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "05:15 PM"));
        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "05:30 PM"));
        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "06:00 PM"));
        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "06:15 PM"));
        appointmentmodelclasslistevening.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "", "", "", "", "", "", R.drawable.doctorimage_profile, "06:30 PM"));


        AppointmentScheduleAdapter appointmentScheduleAdapter = new AppointmentScheduleAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);

        AppointmentScheduleEveningAdapter appointmentScheduleEveningAdapter = new AppointmentScheduleEveningAdapter();
        GridLayoutManager gridLayoutManagerenevening = new GridLayoutManager(getActivity(), 4);

        rv_morningslot.setLayoutManager(gridLayoutManager);
        rv_morningslot.setAdapter(appointmentScheduleAdapter);

        rv_eveningslot.setLayoutManager(gridLayoutManagerenevening);
        rv_eveningslot.setAdapter(appointmentScheduleEveningAdapter);

        view_one.setBackgroundColor(getResources().getColor(R.color.blue_app));
        view_two.setBackgroundColor(getResources().getColor(R.color.gray));
        view_three.setBackgroundColor(getResources().getColor(R.color.gray));
        view_four.setBackgroundColor(getResources().getColor(R.color.gray));
        view_five.setBackgroundColor(getResources().getColor(R.color.gray));



        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
            }
        };

        calender_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getActivity(),date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(android.icu.util.Calendar.DAY_OF_MONTH)).show();

            }
        });


        lv_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_one.setBackgroundColor(getResources().getColor(R.color.blue_app));
                view_two.setBackgroundColor(getResources().getColor(R.color.gray));
                view_three.setBackgroundColor(getResources().getColor(R.color.gray));
                view_four.setBackgroundColor(getResources().getColor(R.color.gray));
                view_five.setBackgroundColor(getResources().getColor(R.color.gray));
            }
        });

        lv_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_one.setBackgroundColor(getResources().getColor(R.color.gray));
                view_two.setBackgroundColor(getResources().getColor(R.color.blue_app));
                view_three.setBackgroundColor(getResources().getColor(R.color.gray));
                view_four.setBackgroundColor(getResources().getColor(R.color.gray));
                view_five.setBackgroundColor(getResources().getColor(R.color.gray));
            }
        });

        lv_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_one.setBackgroundColor(getResources().getColor(R.color.gray));
                view_two.setBackgroundColor(getResources().getColor(R.color.gray));
                view_three.setBackgroundColor(getResources().getColor(R.color.blue_app));
                view_four.setBackgroundColor(getResources().getColor(R.color.gray));
                view_five.setBackgroundColor(getResources().getColor(R.color.gray));
            }
        });

        lv_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_one.setBackgroundColor(getResources().getColor(R.color.gray));
                view_two.setBackgroundColor(getResources().getColor(R.color.gray));
                view_three.setBackgroundColor(getResources().getColor(R.color.gray));
                view_four.setBackgroundColor(getResources().getColor(R.color.blue_app));
                view_five.setBackgroundColor(getResources().getColor(R.color.gray));
            }
        });

        lv_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_one.setBackgroundColor(getResources().getColor(R.color.gray));
                view_two.setBackgroundColor(getResources().getColor(R.color.gray));
                view_three.setBackgroundColor(getResources().getColor(R.color.gray));
                view_four.setBackgroundColor(getResources().getColor(R.color.gray));
                view_five.setBackgroundColor(getResources().getColor(R.color.blue_app));
            }
        });
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                BookingSuccessFragment bookingSuccessFragment = new BookingSuccessFragment(doctorSpecialityModelClass);
//                openfragment(bookingSuccessFragment, "Booking Success Fragment");
                PatientDetailsFragment patientDetailsFragment = new PatientDetailsFragment(doctorSpecialityModelClass);
                openfragment(patientDetailsFragment,"Patient Details Fragment");
                Utils.blackIconStatusBar(getActivity(), R.color.blue_app);
            }
        });



        return view;
    }

    class AppointmentScheduleAdapter extends RecyclerView.Adapter<AppointmentScheduleAdapter.appointmentscheduleholder> {

        @NonNull
        @Override
        public AppointmentScheduleAdapter.appointmentscheduleholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_timeslot, parent, false);
            return new appointmentscheduleholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AppointmentScheduleAdapter.appointmentscheduleholder holder, int position) {
            AppointmentModelClass appointmentModelClass = appointmentmodelclasslistmorning.get(position);
            if (appointmentModelClass.isIs_selectedMorning()) {
                holder.tv_timeslot.setTextColor(getResources().getColor(R.color.white));
                holder.lv_timeslot.setBackgroundColor(getResources().getColor(R.color.blue_app));
            } else {
                holder.tv_timeslot.setTextColor(getResources().getColor(R.color.blue_app));
                holder.lv_timeslot.setBackgroundColor(getResources().getColor(R.color.white));
            }

            holder.tv_timeslot.setText(appointmentModelClass.getAppointmenttime());

            holder.tv_timeslot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (appointmentModelClass.isIs_selectedMorning()) {
                        appointmentModelClass.setIs_selectedMorning(false);

                    }else {
                        for (int i = 0; i < appointmentmodelclasslistmorning.size(); i++) {
                            appointmentmodelclasslistmorning.get(i).setIs_selectedMorning(false);
                        }
                        appointmentModelClass.setIs_selectedMorning(true);
                    }
                    notifyDataSetChanged();
                }
            });

        }

        @Override
        public int getItemCount() {
            return appointmentmodelclasslistmorning.size();
        }

        public class appointmentscheduleholder extends RecyclerView.ViewHolder {
            TextView tv_timeslot;
            LinearLayout lv_timeslot;

            public appointmentscheduleholder(@NonNull View itemView) {
                super(itemView);

                tv_timeslot = itemView.findViewById(R.id.tv_timeslot);
                lv_timeslot = itemView.findViewById(R.id.lv_timeslot);

            }
        }
    }

    class AppointmentScheduleEveningAdapter extends RecyclerView.Adapter<AppointmentScheduleEveningAdapter.appointmentscheduleeveningholder> {

        @NonNull
        @Override
        public AppointmentScheduleEveningAdapter.appointmentscheduleeveningholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_timeslot, parent, false);
            return new appointmentscheduleeveningholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AppointmentScheduleEveningAdapter.appointmentscheduleeveningholder holder, int position) {
            AppointmentModelClass appointmentModelClass = appointmentmodelclasslistevening.get(position);
            if (appointmentModelClass.isIs_selectedEvening()) {
                holder.tv_timeslot.setTextColor(getResources().getColor(R.color.white));
                holder.lv_timeslot.setBackgroundColor(getResources().getColor(R.color.blue_app));
            } else {
                holder.tv_timeslot.setTextColor(getResources().getColor(R.color.blue_app));
                holder.lv_timeslot.setBackgroundColor(getResources().getColor(R.color.white));
            }


            holder.tv_timeslot.setText(appointmentModelClass.getAppointmenttime());

            holder.tv_timeslot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (appointmentModelClass.isIs_selectedEvening()) {
                        appointmentModelClass.setIs_selectedEvening(false);
                    } else {
                        for (int i = 0; i < appointmentmodelclasslistevening.size(); i++) {
                            appointmentmodelclasslistevening.get(i).setIs_selectedEvening(false);
                        }
                        appointmentModelClass.setIs_selectedEvening(true);
                    }
                    notifyDataSetChanged();
//                    notifyItemChanged(position);
//                    BookingSuccessFragment bookingSuccessFragment = new BookingSuccessFragment(doctorSpecialityModelClass);
//                    openfragment(bookingSuccessFragment,"Booking Success Fragment");

                }
            });
        }

        @Override
        public int getItemCount() {
            return appointmentmodelclasslistevening.size();
        }

        public class appointmentscheduleeveningholder extends RecyclerView.ViewHolder {
            TextView tv_timeslot;
            LinearLayout lv_timeslot;

            public appointmentscheduleeveningholder(@NonNull View itemView) {
                super(itemView);
                tv_timeslot = itemView.findViewById(R.id.tv_timeslot);
                lv_timeslot = itemView.findViewById(R.id.lv_timeslot);
            }
        }
    }



    private void openfragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_appointmentschedule, fragment, tag).addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
        Utils.blackIconStatusBar(getActivity(), R.color.blue_app);
    }
}