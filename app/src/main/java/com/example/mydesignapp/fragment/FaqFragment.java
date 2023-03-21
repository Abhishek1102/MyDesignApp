package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mydesignapp.model.FaqModel;
import com.example.mydesignapp.R;

import java.util.ArrayList;
import java.util.List;

public class FaqFragment extends Fragment {

    View view;
    RecyclerView rv_faq;
    FaqModel faqModel;
    ImageView iv_arrowup,iv_arrowdown,iv_back;
    private List<FaqModel> faqModelList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_faq, container, false);
        rv_faq = view.findViewById(R.id.rv_faq);
        iv_arrowdown = view.findViewById(R.id.iv_arrowdown);
        iv_back = view.findViewById(R.id.iv_faqback);
        iv_arrowup = view.findViewById(R.id.iv_arrowup);



        faqModelList =  new ArrayList<>();

        faqModelList.add(new FaqModel("What is Find Doctor","It is an app to find doctor",false));
        faqModelList.add(new FaqModel("How to use this app","Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",false));
        faqModelList.add(new FaqModel("What is Find Doctor","It is an app to find doctor",false));
        faqModelList.add(new FaqModel("How to use this app","Lorem Ipsum is simply dummy text of the printing and typesetting industry.Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",false));
        faqModelList.add(new FaqModel("What is Find Doctor","It is an app to find doctor",false));

        FaqAdapter faqAdapter = new FaqAdapter(this,faqModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        rv_faq.setLayoutManager(linearLayoutManager);
        rv_faq.setAdapter(faqAdapter);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress("Faq Fragment");
            }
        });

        return view;
    }

    class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.faqholder>{
        public FaqAdapter(FaqFragment faqFragment, List<FaqModel> faqModelList) {
        }

        @NonNull
        @Override
        public FaqAdapter.faqholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_faq,parent,false);
            return new faqholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FaqAdapter.faqholder holder, int position) {
            FaqModel faqModel = faqModelList.get(position);
            holder.tv_question.setText(faqModel.getQuestion());
            holder.tv_answer.setText(faqModel.getAnswer());

            if (faqModel.isIs_selected()){
                holder.tv_answer.setVisibility(View.VISIBLE);
                holder.iv_arrowdown.setVisibility(View.GONE);
                holder.iv_arrowup.setVisibility(View.VISIBLE);
            }
            else {
                holder.tv_answer.setVisibility(View.GONE);
                holder.iv_arrowdown.setVisibility(View.VISIBLE);
                holder.iv_arrowup.setVisibility(View.GONE);
            }

            holder.tv_question.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (faqModel.isIs_selected()){
                        faqModel.setIs_selected(false);
                    }
                    else {
                        for (int i = 0; i < faqModelList.size(); i++) {
                            faqModelList.get(i).setIs_selected(false);
                        }
                        faqModel.setIs_selected(true);
                    }
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return faqModelList.size();
        }

        public class faqholder extends RecyclerView.ViewHolder {
            TextView tv_question,tv_answer;
            ImageView iv_arrowup,iv_arrowdown;
            public faqholder(@NonNull View itemView) {
                super(itemView);

                iv_arrowup = itemView.findViewById(R.id.iv_arrowup);
                iv_arrowdown = itemView.findViewById(R.id.iv_arrowdown);
                tv_question = itemView.findViewById(R.id.tv_question);
                tv_answer = itemView.findViewById(R.id.tv_answer);
            }
        }
    }

    private void backpress(String tag) {
        getActivity().getSupportFragmentManager().popBackStack();
    }

}