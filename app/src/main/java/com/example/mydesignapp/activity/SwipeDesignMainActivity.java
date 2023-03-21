package com.example.mydesignapp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mydesignapp.R;
import com.example.mydesignapp.fragment.BookAppointmentFragment;
import com.example.mydesignapp.fragment.ConsultDoctorOnline;
import com.example.mydesignapp.fragment.FragmentFindDoctor;
import com.example.mydesignapp.helper.Utils;

import java.util.ArrayList;
import java.util.List;

public class SwipeDesignMainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_design_main);

        getSupportActionBar().hide();
        Utils.blackIconStatusBar(SwipeDesignMainActivity.this, R.color.white);
        //try to declare viewpager using basic declaration instaed of butterknife or viewbinding
        viewPager = findViewById(R.id.viewpager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.add(new FragmentFindDoctor());
        viewPagerAdapter.add(new BookAppointmentFragment());
        viewPagerAdapter.add(new ConsultDoctorOnline());

        viewPager.setAdapter(viewPagerAdapter);

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragments = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public void add(Fragment fragment) {
            fragments.add(fragment);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}