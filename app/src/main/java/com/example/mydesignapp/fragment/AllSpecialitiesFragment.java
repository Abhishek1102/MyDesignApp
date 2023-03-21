package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydesignapp.R;
import com.example.mydesignapp.model.SpecialitiesModelClass;
import com.example.mydesignapp.helper.Utils;
import com.mlsdev.animatedrv.AnimatedRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllSpecialitiesFragment extends Fragment {

    View view;
    ImageView iv_backall;
    private RecyclerView recyclerView;
    private List<SpecialitiesModelClass> specialitiesModelClassList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_specialities, container, false);
        recyclerView = view.findViewById(R.id.rv_allspecialities);
        iv_backall = view.findViewById(R.id.iv_allspecialitiesBack);
        specialitiesModelClassList = new ArrayList<>();

        Utils.blackIconStatusBar(getActivity(), R.color.white);


        iv_backall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress(new HomeFragment(), "All Spcialities Fragment");
            }
        });

        specialitiesModelClassList.add(new SpecialitiesModelClass("Heart Disease", R.drawable.heart));
        specialitiesModelClassList.add(new SpecialitiesModelClass("Dental Care", R.drawable.tooth));
        specialitiesModelClassList.add(new SpecialitiesModelClass("Skin Care", R.drawable.massage));
        specialitiesModelClassList.add(new SpecialitiesModelClass("Eye Specialities", R.drawable.eye));
        specialitiesModelClassList.add(new SpecialitiesModelClass("Mental Health", R.drawable.mental_health));
        specialitiesModelClassList.add(new SpecialitiesModelClass("Lungs Disease", R.drawable.lungs));
        specialitiesModelClassList.add(new SpecialitiesModelClass("Kidney Disease", R.drawable.kidneys));
        specialitiesModelClassList.add(new SpecialitiesModelClass("Digestive Issues", R.drawable.stomach));
        specialitiesModelClassList.add(new SpecialitiesModelClass("General Physician", R.drawable.user_girl));
        specialitiesModelClassList.add(new SpecialitiesModelClass("Ear, Nose", R.drawable.ear));

        AllSpecialAdapter allSpecialAdapter = new AllSpecialAdapter(this, specialitiesModelClassList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(allSpecialAdapter);
        recyclerView.scheduleLayoutAnimation();

        return view;
    }

    class AllSpecialAdapter extends RecyclerView.Adapter<AllSpecialAdapter.allspecialholder> {

        public AllSpecialAdapter(AllSpecialitiesFragment allSpecialitiesFragment, List<SpecialitiesModelClass> specialitiesModelClassList) {
        }

        @NonNull
        @Override
        public AllSpecialAdapter.allspecialholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_allspecialities, parent, false);
            return new allspecialholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AllSpecialAdapter.allspecialholder holder, int position) {
            SpecialitiesModelClass specialitiesModelClass = specialitiesModelClassList.get(position);
            holder.textView.setText(specialitiesModelClass.getName());
            holder.imageView.setImageResource(specialitiesModelClass.getImage());

//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    openfragment(new HeartDiseaseSpecialistFragment(),"HeartDiseaseSpecialityFragment");
//                }
//            });
        }

        @Override
        public int getItemCount() {
            return specialitiesModelClassList.size();
        }

        public class allspecialholder extends RecyclerView.ViewHolder implements View.OnClickListener {

            ImageView imageView;
            TextView textView;

            public allspecialholder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.iv_allspecialities);
                textView = itemView.findViewById(R.id.tv_allspecilities);

                itemView.setClickable(true);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (getLayoutPosition() == 0) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                    // Toast.makeText(getContext(), "Heart Disease clicked", Toast.LENGTH_SHORT).show();
                } else if (getLayoutPosition() == 1) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else if (getLayoutPosition() == 2) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else if (getLayoutPosition() == 3) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else if (getLayoutPosition() == 4) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else if (getLayoutPosition() == 5) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else if (getLayoutPosition() == 6) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else if (getLayoutPosition() == 7) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else if (getLayoutPosition() == 8) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else if (getLayoutPosition() == 9) {
                    openfragment(new HeartDiseaseSpecialistFragment(), "HeartDiseaseSpecialityFragment");
                } else {
                    Toast.makeText(getContext(), "Cicked it", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void backpress(Fragment fragment, String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    private void openfragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_allspecialities, fragment, tag).addToBackStack(null);
        fragmentTransaction.commit();
    }


}