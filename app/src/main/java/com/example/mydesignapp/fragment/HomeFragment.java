package com.example.mydesignapp.fragment;

import android.graphics.Typeface;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydesignapp.activity.MainActivity;
import com.example.mydesignapp.model.AppointmentModelClass;
import com.example.mydesignapp.R;
import com.example.mydesignapp.model.SpecialitiesModelClass;
import com.example.mydesignapp.helper.Utils;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    View view;
    private RecyclerView recyclerView, rv_appointment, rv_previouslyvisited;
    private List<SpecialitiesModelClass> specialitiesModelClassList;
    private List<AppointmentModelClass> appointmentModelClasseslist;
    private ImageView iv_bell, iv_profile;
    private TextView tv_viewall, tv_viewappointment, view_previouslyvisited;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rv_specialities);
        rv_appointment = view.findViewById(R.id.rv_appointment);
        tv_viewall = view.findViewById(R.id.tv_viewall);
        tv_viewappointment = view.findViewById(R.id.tv_viewappointment);
        iv_bell = view.findViewById(R.id.iv_bell);
        iv_profile = view.findViewById(R.id.iv_profile);
        rv_previouslyvisited = view.findViewById(R.id.rv_previouslyvisited);
        view_previouslyvisited = view.findViewById(R.id.tv_viewpreviouslyvisited);

        Utils.blackIconStatusBar(getActivity(), R.color.white);


        specialitiesModelClassList = new ArrayList<>();
        appointmentModelClasseslist = new ArrayList<>();


        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.heart_disease), R.drawable.heart));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.dental_care), R.drawable.tooth));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.skin_care), R.drawable.massage));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.eye_specialities), R.drawable.eye));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.mental_health), R.drawable.mental_health));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.lungs), R.drawable.lungs));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.kidney_disease), R.drawable.kidneys));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.digestive_disease), R.drawable.stomach));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.general_physician), R.drawable.user_girl));
        specialitiesModelClassList.add(new SpecialitiesModelClass(getResources().getString(R.string.ear_nose), R.drawable.ear));

        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctor_image, "Dr.Raymond Martin", "145 Valencia St, San Francisco",
                "6:00", "PM", "", "Cardiologist", R.drawable.user_icon, ""));
        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "Dr.Sam Singh", "145 Rossenburg, LA-10234",
                "10:00", "AM", "", "Physiotherapist", R.drawable.user_icon, ""));
        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctor_image, "Dr.Jack Nicole", "105 Homles Street, Silicon Valley California",
                "12:00", "PM", "", "Psychiatrists", R.drawable.user_icon, ""));
        appointmentModelClasseslist.add(new AppointmentModelClass(R.drawable.doctorimage_profile, "Dr.Chris Jey", "145 Rossenburg, LA-10235",
                "10:00", "AM", "", "Neurologists", R.drawable.user_icon, ","));


        PreviouslyVisitedAdapter previouslyVisitedAdapter = new PreviouslyVisitedAdapter(this, appointmentModelClasseslist);
        LinearLayoutManager layoutManagerDoctor = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        rv_previouslyvisited.setLayoutManager(layoutManagerDoctor);
        rv_previouslyvisited.setAdapter(previouslyVisitedAdapter);

        SpecialitiesAdapter specialitiesAdapter = new SpecialitiesAdapter(this, specialitiesModelClassList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(specialitiesAdapter);

        DoctorAppointmentAdapter doctorAppointmentAdapter = new DoctorAppointmentAdapter(this, appointmentModelClasseslist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        rv_appointment.setLayoutManager(layoutManager);
        rv_appointment.setAdapter(doctorAppointmentAdapter);

        tv_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewallfragment(new AllSpecialitiesFragment(), "View All Specialities Fragment");
            }
        });

        iv_bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewallfragment(new NotificationFragment(), "Notification Fragment");
            }
        });

        tv_viewappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewfragment(new AppointmentFragment(), "Apointment Fragment");
            }
        });

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewallfragment(new MyProfileFragment(), "My Profile Fragment");
            }
        });

        view_previouslyvisited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewfragment(new AppointmentFragment(), "Apointment Fragment");
            }
        });

        return view;
    }

    class DoctorAppointmentAdapter extends RecyclerView.Adapter<DoctorAppointmentAdapter.appointmentholder> {

        public DoctorAppointmentAdapter(HomeFragment homeFragment, List<AppointmentModelClass> appointmentModelClasseslist) {
        }

        @NonNull
        @Override
        public DoctorAppointmentAdapter.appointmentholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_appointment, parent, false);
            return new appointmentholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DoctorAppointmentAdapter.appointmentholder holder, int position) {
            AppointmentModelClass appointmentModelClass = appointmentModelClasseslist.get(position);
            holder.tv_doctorname.setText(appointmentModelClass.getDoctorname());
            holder.iv_doctorimage.setImageResource(appointmentModelClass.getDoctorimage());
            holder.tv_doctoraddress.setText(appointmentModelClass.getDoctoraddress());
            holder.tv_doctortime.setText(appointmentModelClass.getDoctortime());
            holder.tv_doctortimeAmPm.setText(appointmentModelClass.getDoctortimeAmPm());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewfragment(new AppointmentFragment(), "Apointment Fragment");

                }
            });

        }

        @Override
        public int getItemCount() {
            return appointmentModelClasseslist.size();
        }

        public class appointmentholder extends RecyclerView.ViewHolder {
            ImageView iv_doctorimage;
            TextView tv_doctorname, tv_doctoraddress, tv_doctortime, tv_doctortimeAmPm;

            public appointmentholder(@NonNull View itemView) {
                super(itemView);

                iv_doctorimage = itemView.findViewById(R.id.iv_AppoinmentDoctorImage);
                tv_doctorname = itemView.findViewById(R.id.tv_AppointmentDoctorName);
                tv_doctoraddress = itemView.findViewById(R.id.tv_AppointmentDoctorAddress);
                tv_doctortime = itemView.findViewById(R.id.tv_AppointmentDoctorTime);
                tv_doctortimeAmPm = itemView.findViewById(R.id.tv_AppointmentDoctorTimeDayNight);

            }
        }
    }

    class SpecialitiesAdapter extends RecyclerView.Adapter<SpecialitiesAdapter.specialitiesholder> {

        public SpecialitiesAdapter(HomeFragment homeFragment, List<SpecialitiesModelClass> specialitiesModelClassList) {
        }

        @NonNull
        @Override
        public SpecialitiesAdapter.specialitiesholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_specilities, parent, false);
            return new specialitiesholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SpecialitiesAdapter.specialitiesholder holder, int position) {
            SpecialitiesModelClass specialitiesModelClass = specialitiesModelClassList.get(position);
            holder.textView.setText(specialitiesModelClass.getName());
            holder.imageView.setImageResource(specialitiesModelClass.getImage());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewallfragment(new AllSpecialitiesFragment(), "All Specialities Fragment");
                }
            });

        }

        @Override
        public int getItemCount() {
            return specialitiesModelClassList.size();
        }

        public class specialitiesholder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;

            public specialitiesholder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.iv_rvlist);
                textView = itemView.findViewById(R.id.tv_rvlist);
            }
        }
    }

    class PreviouslyVisitedAdapter extends RecyclerView.Adapter<PreviouslyVisitedAdapter.previouslyvisitedholder> {
        public PreviouslyVisitedAdapter(HomeFragment homeFragment, List<AppointmentModelClass> appointmentModelClasseslist) {
        }

        @NonNull
        @Override
        public PreviouslyVisitedAdapter.previouslyvisitedholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_previouslyvisiteddoctor, parent, false);
            return new previouslyvisitedholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PreviouslyVisitedAdapter.previouslyvisitedholder holder, int position) {
            AppointmentModelClass appointmentModelClass = appointmentModelClasseslist.get(position);
            holder.tv_name.setText(appointmentModelClass.getDoctorname());
            holder.tv_address.setText(appointmentModelClass.getDoctoraddress());
            holder.tv_specilaity.setText(appointmentModelClass.getDoctorspeciality());
            holder.iv_doctorimage.setImageResource(appointmentModelClass.getDoctorimage());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewfragment(new AppointmentFragment(), "Apointment Fragment");

                }
            });
        }

        @Override
        public int getItemCount() {
            return appointmentModelClasseslist.size();
        }

        public class previouslyvisitedholder extends RecyclerView.ViewHolder {
            TextView tv_name, tv_specilaity, tv_address;
            ImageView iv_doctorimage;

            public previouslyvisitedholder(@NonNull View itemView) {
                super(itemView);

                tv_name = itemView.findViewById(R.id.tv_previouslyvisiteddoctorname);
                tv_specilaity = itemView.findViewById(R.id.tv_previouslyvisiteddoctorspeciality);
                tv_address = itemView.findViewById(R.id.tv_previouslyvisiteddoctoraddress);
                iv_doctorimage = itemView.findViewById(R.id.iv_previouslyvisiteddoctorimage);
            }
        }
    }

    private void introtourapp(){
        new TapTargetSequence(getActivity())
                .targets(
                        TapTarget.forView(iv_profile,"Button 1","This is Button 1")
                                .outerCircleColor(R.color.teal_200)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(10)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(iv_bell,"Button 2","This is Button 2")
                                .outerCircleColor(R.color.teal_200)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(10)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(view_previouslyvisited,"Button 3","This is Button 3")
                                .outerCircleColor(R.color.teal_200)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(10)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(tv_viewall,"Button 3","This is Button 3")
                                .outerCircleColor(R.color.teal_200)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(10)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(tv_viewappointment,"Button 3","This is Button 3")
                                .outerCircleColor(R.color.red)
                                .outerCircleAlpha(0.96f)
                                .targetCircleColor(R.color.white)
                                .titleTextSize(20)
                                .titleTextColor(R.color.white)
                                .descriptionTextSize(10)
                                .descriptionTextColor(R.color.black)
                                .textColor(R.color.black)
                                .textTypeface(Typeface.SANS_SERIF)
                                .dimColor(R.color.black)
                                .drawShadow(true)
                                .cancelable(false)
                                .tintTarget(true)
                                .transparentTarget(true)
                                .targetRadius(60)).listener(new TapTargetSequence.Listener() {
            @Override
            public void onSequenceFinish() {

                Toast.makeText(getContext(),"Sequence Finished",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                Toast.makeText(getContext(),"GREAT!",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSequenceCanceled(TapTarget lastTarget) {

            }
        }).start();
    }

    private void tourapp(){
        TapTargetView.showFor(getActivity(),                 // `this` is an Activity
                TapTarget.forView(iv_profile, "This is a target", "We have the best targets, believe me")
                        // All options below are optional
                        .outerCircleColor(R.color.red)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.white)   // Specify a color for the target circle
                        .titleTextSize(20)                  // Specify the size (in sp) of the title text
                        .titleTextColor(R.color.white)      // Specify the color of the title text
                        .descriptionTextSize(10)            // Specify the size (in sp) of the description text
                        .descriptionTextColor(R.color.red)  // Specify the color of the description text
                        .textColor(R.color.blue)            // Specify a color for both the title and description text
                        .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                        .dimColor(R.color.black)            // If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)                   // Whether to draw a drop shadow or not
                        .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(false)           // Specify whether the target is transparent (displays the content underneath)
                        .targetRadius(60),                  // Specify the target radius (in dp)
                new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional
                        Toast.makeText(getActivity(), "Tour clicked", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void viewallfragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_full, fragment, tag).addToBackStack(null);
        fragmentTransaction.commit();
    }


    private void viewfragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.framelayout_main, fragment, tag).addToBackStack(null);
        fragmentTransaction.commit();
    }

}