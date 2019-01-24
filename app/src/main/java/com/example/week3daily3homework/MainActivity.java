package com.example.week3daily3homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.week3daily3homework.events.UserEvent;
import com.example.week3daily3homework.model.datasource.httpUrlConnection.HttpUrlConnTask;
import com.example.week3daily3homework.model.user.Result;
import com.example.week3daily3homework.model.user.UserResponse;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter rvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpUrlConnTask httpUrlConnTask = new HttpUrlConnTask();
        httpUrlConnTask.execute();

        recyclerView = findViewById(R.id.rvMainRecyclerView);



    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userEvent(UserEvent event){
        if(event != null){
            UserResponse userResponse = event.getUserResponse();
            ArrayList<Result> resultArrayList = new ArrayList<>(userResponse.getResults());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            rvAdapter = new RecyclerViewAdapter(resultArrayList);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(rvAdapter);
            //tvDisplay.setText(userResponse.getResults().get(0).getEmail());
            Log.d("TAG", "userEvent: " + userResponse.getResults().get(0).getEmail());
        }
    }

}
