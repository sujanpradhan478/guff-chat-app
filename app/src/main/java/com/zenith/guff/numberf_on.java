package com.zenith.guff;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class numberf_on extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_numberf_on,null);

        final EditText number = view.findViewById(R.id.number_edittext);
        Button verifybut = view.findViewById(R.id.verify);

        verifybut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setTextColor(getResources().getColor(R.color.colorAccent));

            }
        });



        return view;


    }
}
