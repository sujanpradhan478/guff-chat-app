package com.zenith.guff;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.jaeger.library.StatusBarUtil;

public class Onboarding_main extends AppCompatActivity {

    ViewPager onpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_main);

        //transparent status bar.
        StatusBarUtil.setTransparent(this);


        //finding.
        onpager = findViewById(R.id.onviewpager);

        //adapter setting.
        Onboarding_adapter onboarding_adapter = new Onboarding_adapter(getSupportFragmentManager());
        onpager.setAdapter(onboarding_adapter);
        onpager.beginFakeDrag();




    }



    public void NextClick(View view){
        int a = onpager.getCurrentItem();
        onpager.setCurrentItem(a + 1);

    }





    // adapter for registration.
    public  class Onboarding_adapter extends FragmentPagerAdapter{

        public Onboarding_adapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            if (position == 0){

                return new profilef_on();
            }else if (position == 2) {

                return new emailf_on();
            }
            else {

                return new numberf_on();

            }
        }

        @Override
        public int getCount() {
            return 3;
        }

    }
}
