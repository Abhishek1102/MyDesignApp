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

public class FavouritesFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<DoctorSpecialityModelClass> doctorSpecialityModelClassList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourites, container, false);
        recyclerView = view.findViewById(R.id.rv_favourites);
        doctorSpecialityModelClassList = new ArrayList<>();


        Utils.blackIconStatusBar(getActivity(), R.color.white);


        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Raymond Martin","Cardiologist, MBBS",
                "25+ Years of experience","4.9","(209 Reviews)",
                "3.2mi",R.drawable.doctor_image,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "M.B.B.S., Cardio Specialist","Mon-Fri, 09:00 AM - 08:00 PM","145 Valencia St, San\n Francisco, CA 94103, \n United States","Tom Hank","Very Good Doctor. Very fine Gentleman. ",R.drawable.user_icon,"4.5","ZY123456","05 Feb","03:00 PM","CLinic Visit","\u20B9 200"));

        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Sam Singh","Physiotherapist",
                "23+ Years of experience","4.4","(180 Reviews)",
                "3.2mi",R.drawable.doctorimage_profile,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "M.D., Physiotherapist","Mon-Fri, 08:00 AM - 09:00 PM","145 Rossenburg,\n LA-10234,\n United States",
                "Jimmy Singh","Nice doctor knows it's works.\n Very Polite and honest.",R.drawable.user_icon,"4.2","ZY123456","05 Feb","03:00 PM","CLinic Visit","\u20B9 200"));

        doctorSpecialityModelClassList.add(new DoctorSpecialityModelClass("Jack Nicole","Psychiatrists",
                "20+ Years of experience","2.5","(50 Reviews)",
                "4.4mi",R.drawable.doctor_image,"Book Appointment","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "M.B.B.S., Psychiatrists ","Mon-Sat, 10:00 AM - 06:00 PM","105 Homles Street,\n Silicon Valley California-12398,\n United States","Jason Shah",
                "Nice Doctor and very well knows it's work, works patiently and understands patients a lot.",R.drawable.user_icon,"4.1","ZY123456","05 Feb","03:00 PM","CLinic Visit","\u20B9 200"));

        FavouritesDoctorAdapter favouritesDoctorAdapter = new FavouritesDoctorAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(favouritesDoctorAdapter);

        return view;
    }

    class FavouritesDoctorAdapter extends RecyclerView.Adapter<FavouritesDoctorAdapter.favouritesdoctorholder>
    {
        @NonNull
        @Override
        public FavouritesDoctorAdapter.favouritesdoctorholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_favourites,parent,false);
            return new favouritesdoctorholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FavouritesDoctorAdapter.favouritesdoctorholder holder, int position) {
            DoctorSpecialityModelClass favouritesDoctorModelClass = doctorSpecialityModelClassList.get(position);
            holder.iv_doctorimage.setImageResource(favouritesDoctorModelClass.getDoctorimage());
            holder.tv_doctorname.setText(favouritesDoctorModelClass.getDoctorname());
            holder.tv_doctorspeciality.setText(favouritesDoctorModelClass.getDoctorSpeciality());
            holder.tv_doctorexperience.setText(favouritesDoctorModelClass.getDoctorExperience());
            holder.tv_doctorrating.setText(favouritesDoctorModelClass.getDoctorRating());
            holder.tv_doctorratingnumber.setText(favouritesDoctorModelClass.getDoctorRatingnumber());
            holder.tv_doctordistance.setText(favouritesDoctorModelClass.getDoctordistance());
            holder.tv_bookappointment.setText(favouritesDoctorModelClass.getBtn_bookappointment());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openfragment(new DoctorProfileFragment(favouritesDoctorModelClass),"Doctor Profile Fragment");
                }
            });
        }

        @Override
        public int getItemCount() {
            return doctorSpecialityModelClassList.size();
        }

        public class favouritesdoctorholder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView iv_doctorimage;
            TextView tv_doctorname,tv_doctorspeciality,tv_doctorexperience,tv_doctorrating,tv_doctorratingnumber,tv_doctordistance,tv_bookappointment;

            public favouritesdoctorholder(@NonNull View itemView) {
                super(itemView);

                iv_doctorimage = itemView.findViewById(R.id.specialistdoctorimage);
                tv_doctorname = itemView.findViewById(R.id.tv_doctorname);
                tv_doctorspeciality = itemView.findViewById(R.id.tv_doctorspeciality);
                tv_doctorexperience = itemView.findViewById(R.id.tv_experience);
                tv_doctorrating = itemView.findViewById(R.id.tv_rating);
                tv_doctorratingnumber = itemView.findViewById(R.id.tv_ratingnumber);
                tv_doctordistance = itemView.findViewById(R.id.tv_doctordistance);
                tv_bookappointment = itemView.findViewById(R.id.btn_bookappointment);

                itemView.setClickable(true);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

            }
        }
    }
    private void openfragment(Fragment fragment,String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_full,fragment,tag).addToBackStack(null);
        fragmentTransaction.commit();
    }
}