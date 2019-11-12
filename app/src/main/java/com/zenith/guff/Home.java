package com.zenith.guff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Home extends AppCompatActivity {
    ImageView msg,add,search;
    RelativeLayout tab1,tab2,tab3,tab4;
    ViewPager pager;
    DowntabsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        tab4 = findViewById(R.id.tab4);
        msg = findViewById(R.id.chat);
        add = findViewById(R.id.add);
        search = findViewById(R.id.search);
        pager = findViewById(R.id.viewpager);
        adapter = new DowntabsAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        pager.setCurrentItem(0);
        msg.setImageResource(R.drawable.msgclick);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    defaulttabs();
                    msg.setImageResource(R.drawable.msgclick);
                }else if (position == 1){
                    defaulttabs();
                    add.setImageResource(R.drawable.addclick);
                }else if (position == 2) {
                    defaulttabs();
                    search.setImageResource(R.drawable.searchclick);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void tabClick(View view){
        if (view.getId() == R.id.tab1) {
            defaulttabs();
            pager.setCurrentItem(0);
            msg.setImageResource(R.drawable.msgclick);
        }
        else if (view.getId() == R.id.tab2){
            defaulttabs();
            pager.setCurrentItem(1);
            add.setImageResource(R.drawable.addclick);

        }
        else if (view.getId() == R.id.tab3) {
            defaulttabs();
            pager.setCurrentItem(2);
            search.setImageResource(R.drawable.searchclick);

        }
        else if (view.getId() == R.id.tab4){
            defaulttabs();
            pager.setCurrentItem(3);
        }
    }

    public void defaulttabs(){
        msg.setImageResource(R.drawable.chats);
        add.setImageResource(R.drawable.add);
        search.setImageResource(R.drawable.search);
    }
}
