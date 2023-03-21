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
import android.widget.TextView;

import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.Utils;
import com.example.mydesignapp.model.DoctorSpecialityModelClass;

import java.util.ArrayList;
import java.util.List;


public class HeartDiseaseSpecialistFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ImageView iv_back;
    private List<DoctorSpecialityModelClass> doctorSpecialityModelClassList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_heart_disease_specialist, container, false);
        recyclerView = view.findViewById(R.id.rv_heartdiseasespecialist);
        iv_back = view.findViewById(R.id.iv_allheartdiseasespecialitiesBack);
        doctorSpecialityModelClassList = new ArrayList<>();

        Utils.blackIconStatusBar(getActivity(), R.color.white);


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("All Spcialities Fragment");
            }
        });

        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Dr.Raymond Martin","Cardiologist, MBBS",
                "25+ Years of experience","4.9","(209 Reviews)",
                "3.2mi",R.drawable.doctorimage_profile,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "M.B.B.S., Cardio Specialist","Mon-Fri, 09:00 AM - 08:00 PM","145 Valencia St, San\n Francisco, CA 94103, \n United States",
                "Tom Hank","Very Good Doctor. Very fine Gentleman. ",R.drawable.user_icon,"4.5","JK123456","10 Feb","10:00 AM","Clinic Visit","\u20B9 500"));

        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Dr.Sam Singh","Physiotherapist",
                "23+ Years of experience","4.4","(180 Reviews)",
                "3.2mi",R.drawable.doctor_image,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "M.D., Physiotherapist","Mon-Fri, 08:00 AM - 09:00 PM","145 Rossenburg,\n LA-10234,\n United States",
                "Jimmy Singh","Nice doctor knows it's works.\nVery Polite and honest.",R.drawable.user_icon,"4.2","AB123456","03 Feb","03:00 PM","Regular Visit","\u20B9 400"));

        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Dr.Jack Nicole","Psychiatrists",
                "20+ Years of experience","2.5","(50 Reviews)",
                "4.4mi",R.drawable.doctorimage_profile,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "M.B.B.S., Psychiatrists ","Mon-Sat, 10:00 AM - 06:00 PM","105 Homles Street,\n Silicon Valley California-12398,\n United States","Jason Shah",
                "Nice Doctor and very well knows it's work, works patiently and understands patients a lot.",R.drawable.user_icon,"4.1","CB123456","30 Jan","09:00 AM","CLinic Visit","\u20B9 300"));

        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Dr.Chris Jey","Neurologists","10+ Years of experience","3.5","(250 Reviews)",
                "5.5mi",R.drawable.doctor_image,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "M.D., Neurologists","Mon-Fri, 08:00 AM - 05:00 PM","145 Rossenburg,\n LA-10235,\n United States","Lily Patel","Good doctor",
                R.drawable.user_girl,"3.5","AD123456","20 Feb","02:00 PM","Regular Visit","\u20B9 400"));

        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Dr.Steve Paul","Physicians, MBBS",
                "20+ Years of experience","3.9","(150 Reviews)",
                "4.2mi",R.drawable.doctorimage_profile,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Physicians","Mon-Fri, 07:00 AM - 06:00 PM","53 Queens,\n New York-45231",
                "Sam Mills","Very Bad Doctor does not listen to patient about problems and charges more fee.",R.drawable.user_icon,"2.5","RV123456","02 Feb","12:00 PM","Routine Checkup","\u20B9 350"));

        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Dr.Tony Singh","Radiologists",
                "12+ Years of experience","4.5","(102 Reviews)",
                "1.2mi",R.drawable.doctor_image,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Radiologist","Mon-Fri, 09:00 AM - 08:00 PM","110 Brooklyn Streets,\n New York-18956,\nUnited States","Rachel Smith","Good Doctor works fine and help patient with their problem and keeps place clean and charges reasonable fee.",R.drawable.user_girl,"4.1","ZY123456","05 Feb","03:00 PM","CLinic Visit","\u20B9 200"));

        HeartDiseaseSpecialistAdapter heartDiseaseSpecialistAdapter = new HeartDiseaseSpecialistAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(heartDiseaseSpecialistAdapter);

        return view;
    }

    class HeartDiseaseSpecialistAdapter extends RecyclerView.Adapter<HeartDiseaseSpecialistAdapter.heartdiseasespecialistholder>{

        @NonNull
        @Override
        public HeartDiseaseSpecialistAdapter.heartdiseasespecialistholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_diseasespecialist,parent,false);
            return new heartdiseasespecialistholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull HeartDiseaseSpecialistAdapter.heartdiseasespecialistholder holder, int position) {

            DoctorSpecialityModelClass doctorSpecialityModelClass = doctorSpecialityModelClassList.get(position);
            holder.iv_doctorimage.setImageResource(doctorSpecialityModelClass.getDoctorimage());
            holder.tv_doctorname.setText(doctorSpecialityModelClass.getDoctorname());
            holder.tv_doctorspeciality.setText(doctorSpecialityModelClass.getDoctorSpeciality());
            holder.tv_doctorexperience.setText(doctorSpecialityModelClass.getDoctorExperience());
            holder.tv_doctorrating.setText(doctorSpecialityModelClass.getDoctorRating());
            holder.tv_doctorratingnumber.setText(doctorSpecialityModelClass.getDoctorRatingnumber());
            holder.tv_doctordistance.setText(doctorSpecialityModelClass.getDoctordistance());
            holder.tv_bookappointment.setText(doctorSpecialityModelClass.getBtn_bookappointment());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    DoctorProfileFragment doctorProfileFragment = new DoctorProfileFragment(doctorSpecialityModelClass);
                    openfragment(doctorProfileFragment,"Doctor Profile Fragment");
                }
            });
            holder.tv_bookappointment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppointmentScheduleFragment appointmentScheduleFragment = new AppointmentScheduleFragment(doctorSpecialityModelClass);
                    openfragment(appointmentScheduleFragment,"Appointment Schedule Fragment");

                    //for taking data
//                    PatientDetailsFragment patientDetailsFragment = new PatientDetailsFragment(doctorSpecialityModelClass);
//                    openfragment(patientDetailsFragment,"Patient Details Fragment");
                }
            });

        }

        @Override
        public int getItemCount() {
            return doctorSpecialityModelClassList.size();
        }

        public class heartdiseasespecialistholder extends RecyclerView.ViewHolder
        {
            ImageView iv_doctorimage;
            TextView tv_doctorname,tv_doctorspeciality,tv_doctorexperience,tv_doctorrating,tv_doctorratingnumber,tv_doctordistance,tv_bookappointment;

            public heartdiseasespecialistholder(@NonNull View itemView) {
                super(itemView);
                iv_doctorimage = itemView.findViewById(R.id.specialistdoctorimage);
                tv_doctorname = itemView.findViewById(R.id.tv_doctorname);
                tv_doctorspeciality = itemView.findViewById(R.id.tv_doctorspeciality);
                tv_doctorexperience = itemView.findViewById(R.id.tv_experience);
                tv_doctorrating = itemView.findViewById(R.id.tv_rating);
                tv_doctorratingnumber = itemView.findViewById(R.id.tv_ratingnumber);
                tv_doctordistance = itemView.findViewById(R.id.tv_doctordistance);
                tv_bookappointment = itemView.findViewById(R.id.btn_bookappointment);
            }
        }
    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    private void openfragment(Fragment fragment,String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_heartdiseasespecialities,fragment,tag).addToBackStack(null);
        fragmentTransaction.commit();
    }

}