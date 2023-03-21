package com.example.mydesignapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.mydesignapp.fragment.AppointmentFragment;
import com.example.mydesignapp.fragment.FavouritesFragment;
import com.example.mydesignapp.fragment.HomeFragment;
import com.example.mydesignapp.fragment.MoreFragment;
import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.Utils;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    LinearLayout lv_home, lv_appointments, lv_favourites, lv_more;
    TextView tv_home, tv_appointments, tv_favourites, tv_more;
    ImageView iv_home, iv_appointments, iv_favourites, iv_more;

    //meow
    MeowBottomNavigation meo;
    private final static int ID_HOME = 1;
    private final static int ID_APPOINTMENTS = 2;
    private final static int ID_FAVOURITES = 3;
    private final static int ID_MORE = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        Utils.blackIconStatusBar(MainActivity.this, R.color.white);

        meo = (MeowBottomNavigation) findViewById(R.id.bottom_nav);
        meo.add(new MeowBottomNavigation.Model(1, R.drawable.home_icon));
        meo.add(new MeowBottomNavigation.Model(2, R.drawable.calendar));
        meo.add(new MeowBottomNavigation.Model(3, R.drawable.heart_icon));
        meo.add(new MeowBottomNavigation.Model(4, R.drawable.more));

        replacefragment(new HomeFragment(), "HomeFragment");
        meo.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(), "Clicked item " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        meo.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment select_fragment = null;
                switch (item.getId()) {
                    case ID_HOME:
                        replacefragment(new HomeFragment(), "HomeFragment");
                        break;
                    case ID_APPOINTMENTS:
                        replacefragment(new AppointmentFragment(), "AppointmentFragment");
                        break;
                    case ID_FAVOURITES:
                        replacefragment(new FavouritesFragment(), "FavouritesFragment");
                        break;
                    case ID_MORE:
                        replacefragment(new MoreFragment(), "MoreFragment");
                        break;

                }
            }
        });
        if (!meo.isShowing(ID_HOME))
            meo.show(ID_HOME, true);
        meo.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });


        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
//        lv_home = findViewById(R.id.lv_home);
//        lv_appointments = findViewById(R.id.lv_appointments);
//        lv_favourites = findViewById(R.id.lv_favourites);
//        lv_more = findViewById(R.id.lv_more);
//        tv_home = findViewById(R.id.tv_home);
//        tv_appointments = findViewById(R.id.tv_appointments);
//        tv_favourites = findViewById(R.id.tv_favourites);
//        tv_more = findViewById(R.id.tv_more);
//        iv_home = findViewById(R.id.iv_home);
//        iv_appointments = findViewById(R.id.iv_appointments);
//        iv_favourites = findViewById(R.id.iv_favourites);
//        iv_more = findViewById(R.id.iv_more);


//        iv_home.setColorFilter(getResources().getColor(R.color.blue_app));
//        tv_home.setTextColor(getColor(R.color.blue_app));

//        iv_appointments.setColorFilter(getResources().getColor(R.color.black));
//        tv_appointments.setTextColor(getColor(R.color.black));
//        iv_favourites.setColorFilter(getResources().getColor(R.color.black));
//        tv_favourites.setTextColor(getColor(R.color.black));
//        iv_more.setColorFilter(getResources().getColor(R.color.black));
//        tv_more.setTextColor(getColor(R.color.black));
        replacefragment(new HomeFragment(), "HomeFragment");


//        lv_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iv_home.setColorFilter(getResources().getColor(R.color.blue_app));
//                tv_home.setTextColor(getColor(R.color.blue_app));
//
//                iv_appointments.setColorFilter(getResources().getColor(R.color.black));
//                tv_appointments.setTextColor(getColor(R.color.black));
//                iv_favourites.setColorFilter(getResources().getColor(R.color.black));
//                tv_favourites.setTextColor(getColor(R.color.black));
//                iv_more.setColorFilter(getResources().getColor(R.color.black));
//                tv_more.setTextColor(getColor(R.color.black));
//
//
//                replacefragment(new HomeFragment(), "HomeFragment");
//
//            }
//        });
//
//        lv_appointments.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iv_appointments.setColorFilter(getResources().getColor(R.color.blue_app));
//                tv_appointments.setTextColor(getColor(R.color.blue_app));
//
//                iv_home.setColorFilter(getResources().getColor(R.color.black));
//                tv_home.setTextColor(getColor(R.color.black));
//                iv_favourites.setColorFilter(getResources().getColor(R.color.black));
//                tv_favourites.setTextColor(getColor(R.color.black));
//                iv_more.setColorFilter(getResources().getColor(R.color.black));
//                tv_more.setTextColor(getColor(R.color.black));
//
//                replacefragment(new AppointmentFragment(), "AppointmentFragment");
//            }
//        });
//
//        lv_favourites.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iv_favourites.setColorFilter(getResources().getColor(R.color.blue_app));
//                tv_favourites.setTextColor(getColor(R.color.blue_app));
//
//                iv_appointments.setColorFilter(getResources().getColor(R.color.black));
//                tv_appointments.setTextColor(getColor(R.color.black));
//                iv_home.setColorFilter(getResources().getColor(R.color.black));
//                tv_home.setTextColor(getColor(R.color.black));
//                iv_more.setColorFilter(getResources().getColor(R.color.black));
//                tv_more.setTextColor(getColor(R.color.black));
//
//                replacefragment(new FavouritesFragment(), "FavouritesFragment");
//
//            }
//        });
//
//        lv_more.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iv_more.setColorFilter(getResources().getColor(R.color.blue_app));
//                tv_more.setTextColor(getColor(R.color.blue_app));
//
//                iv_appointments.setColorFilter(getResources().getColor(R.color.black));
//                tv_appointments.setTextColor(getColor(R.color.black));
//                iv_favourites.setColorFilter(getResources().getColor(R.color.black));
//                tv_favourites.setTextColor(getColor(R.color.black));
//                iv_home.setColorFilter(getResources().getColor(R.color.black));
//                tv_home.setTextColor(getColor(R.color.black));
//
//                replacefragment(new MoreFragment(), "MoreFragment");
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Utils.blackIconStatusBar(MainActivity.this, R.color.white);
    }

    private void replacefragment(Fragment fragment, String tag) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_main, fragment);
        fragmentTransaction.commit();
    }
}