package com.example.mydesignapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydesignapp.model.NotificationModelClass;
import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.Utils;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {

    View view;
    private RecyclerView rv_notification;
    ImageView iv_back;
    private List<NotificationModelClass>  notificationModelClassList;
    Button btn_toast;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_notification, container, false);
        rv_notification = view.findViewById(R.id.rv_notification);
        iv_back = view.findViewById(R.id.iv_notificationBack);



        notificationModelClassList = new ArrayList<>();

        notificationModelClassList.add(new NotificationModelClass(R.drawable.notification_icon,"Appointment Reminder","Your appointment will start after 15 minutes.","10 Mins ago"));
        notificationModelClassList.add(new NotificationModelClass(R.drawable.calendar_icon,"Appointment Confirmation","Your appointment with Dr.Luther Jones is confirmed","1 Day ago"));
        notificationModelClassList.add(new NotificationModelClass(R.drawable.notification_icon,"Appointment Reminder","Your appointment will start after 15 minutes.","10 Mins ago"));
        notificationModelClassList.add(new NotificationModelClass(R.drawable.calendar_icon,"Appointment Confirmation","Your appointment with Dr.Luther Jones is confirmed","1 Day ago"));
        Utils.blackIconStatusBar(getActivity(), R.color.white);

        NotificationAdapter notificationAdapter = new NotificationAdapter(this,notificationModelClassList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        rv_notification.setLayoutManager(layoutManager);
        rv_notification.setAdapter(notificationAdapter);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpress();
            }
        });

        return view;
    }

    class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.notificationholder>{
        public NotificationAdapter(NotificationFragment notificationFragment, List<NotificationModelClass> notificationModelClassList) {
        }

        @NonNull
        @Override
        public NotificationAdapter.notificationholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notification,parent,false);
            return new NotificationAdapter.notificationholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NotificationAdapter.notificationholder holder, int position) {
            NotificationModelClass notificationModelClass = notificationModelClassList.get(position);
            holder.tv_notificationTitle.setText(notificationModelClass.getNotificationTitle());
            holder.tv_notificationdescription.setText(notificationModelClass.getNotificationDescription());
            holder.tv_notificationTime.setText(notificationModelClass.getNotificationTime());
            holder.iv_notification_icon.setImageResource(notificationModelClass.getNotificationIcon());
        }

        @Override
        public int getItemCount() {
            return notificationModelClassList.size();
        }

        public class notificationholder extends RecyclerView.ViewHolder {
            ImageView iv_notification_icon;
            TextView tv_notificationTitle,tv_notificationdescription,tv_notificationTime;
            public notificationholder(@NonNull View itemView) {
                super(itemView);

                iv_notification_icon = itemView.findViewById(R.id.iv_notificationicon);
                tv_notificationTitle = itemView.findViewById(R.id.tv_notificationtitle);
                tv_notificationTime = itemView.findViewById(R.id.tv_notificationtime);
                tv_notificationdescription= itemView.findViewById(R.id.tv_notificationdescription);

            }
        }
    }

    private void backpress() {
        getActivity().getSupportFragmentManager().popBackStack();
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