package com.zenith.guff;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class DowntabsAdapter extends FragmentPagerAdapter {
    public DowntabsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){

            return new chatsf();
        }else if (position == 1){
            return new addsf();
        }else if (position == 2){
            return new searchf();
        }else {
            return new profilef();
        }

    }

    @Override
    public int getCount() {

        return 4;
    }
}
