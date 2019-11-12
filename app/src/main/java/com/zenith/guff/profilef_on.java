package com.zenith.guff;

import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class profilef_on extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_profilef_on,null);

        //finding
        Button continue1 = view.findViewById(R.id.continue1);
        ImageView gufflogo = view.findViewById(R.id.gufflogo);
        final EditText firstname = view.findViewById(R.id.firstname);
        final EditText lastname = view.findViewById(R.id.lastname);
        final EditText email = view.findViewById(R.id.email);
        Animation rotate = AnimationUtils.loadAnimation(getContext(),R.anim.rotate);



        //animation
        gufflogo.startAnimation(rotate);
        YoYo.with(Techniques.BounceIn)
                .duration(700)
                .playOn(firstname);
        YoYo.with(Techniques.BounceIn)
                .duration(700)
                .playOn(lastname);
        YoYo.with(Techniques.BounceIn)
                .duration(700)
                .playOn(email);


        // check indicate
        firstname.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (firstname.getText().toString().length() >= 3){
                        firstname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                    }
                    else {
                        firstname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_incorrect, 0);

                    }
                    return true;
                }
                return false;
            }
        });

        lastname.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (lastname.getText().toString().length() >= 3){
                        lastname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                    }
                    else {
                        lastname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_incorrect, 0);

                    }
                    return true;
                }
                return false;
            }
        });

        email.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (email.getText().toString().length() >= 3
                    && Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                        email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                    }
                    else {
                        email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_incorrect, 0);

                    }
                    return true;
                }
                return false;
            }
        });


        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // chech indicate on click.
                if (firstname.getText().toString().length() >= 3){
                    firstname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                }
                if (lastname.getText().toString().length() >= 3){
                        lastname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);
                }
                if (Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()
                        && email.getText().toString().length() >= 3){
                    email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check, 0);

                }


                if (Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()
                && firstname.getText().toString().length() >= 3
                && lastname.getText().toString().length() >= 3
                && email.getText().toString().length() >= 3){

                    // next fragment.
                    // ViewPager vp=(ViewPager) getActivity().findViewById(ViewPagerId); /OR
                    ViewPager fragpager = (ViewPager) container;
                    int a = fragpager.getCurrentItem();
                    fragpager.setCurrentItem(a + 1);
                }else {

                    // negative check indicate.
                    if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                        email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_incorrect, 0);
                    }
                    if (firstname.getText().toString().length() < 3) {
                        firstname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_incorrect, 0);
                    }
                    if (lastname.getText().toString().length() < 3) {
                        lastname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_incorrect, 0);
                    }
                    if (email.getText().toString().length() < 3) {
                        email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.check_incorrect, 0);
                    }
                }


            }
        });


        return view;
    }
}
