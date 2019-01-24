package com.example.week3daily3homework;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week3daily3homework.model.user.Result;

public class DisplayActivity extends AppCompatActivity {
    public static final String FRAG = "frag_display";
    TextView tvField1, tvField2, tvField3, tvField4, tvField5, tvField6, tvField7, tvField8, tvField9, tvField10;
    DisplayFragment displayFragment;
    FragmentManager fm;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        result = (Result)getIntent().getParcelableExtra("person");
        displayFragment = new DisplayFragment();
        fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.fragPlaceHolderOne, displayFragment).addToBackStack(FRAG).commit();

        tvField1 = findViewById(R.id.tvField1);
        tvField2 = findViewById(R.id.tvField2);
        tvField3 = findViewById(R.id.tvField3);
        tvField4 = findViewById(R.id.tvField4);
        tvField5 = findViewById(R.id.tvField5);
        tvField6 = findViewById(R.id.tvField6);
        tvField7 = findViewById(R.id.tvField7);
        tvField8 = findViewById(R.id.tvField8);
        tvField9 = findViewById(R.id.tvField9);
        tvField10 = findViewById(R.id.tvField10);
        tvField1.setText("Name: " + result.getName().getFirst() + " " + result.getName().getLast());
        tvField2.setText("Gender: " + result.getGender());
        tvField3.setText("Street: " + result.getLocation().getStreet());
        tvField4.setText("City: " + result.getLocation().getCity());
        tvField5.setText("State:" + result.getLocation().getState());
        tvField6.setText("Date of Birth: " + result.getDob().getDate());
        tvField7.setText("Phone Number: "+ result.getPhone());
        tvField8.setText("Email: " + result.getEmail());
        tvField9.setText("Username: " + result.getLogin().getUsername());
        tvField10.setText("Password: " + result.getLogin().getPassword());
        displayFragment.setDisplay(result.getPicture().getLarge());
    }

}
