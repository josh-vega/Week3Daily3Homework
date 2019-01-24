package com.example.week3daily3homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.week3daily3homework.model.user.Result;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Result> userArrayList;

    public RecyclerViewAdapter(ArrayList<Result> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Result result = userArrayList.get(position);
        if(result != null){
            String name = result.getName().getFirst() + " " + result.getName().getLast();
            String username = result.getLogin().getUsername();
            String password = result.getLogin().getPassword();
            String dob = result.getDob().getDate();
            String gender = result.getGender();
            String street = result.getLocation().getStreet();
            String city = result.getLocation().getCity();
            String state = result.getLocation().getState();
            String phone = result.getPhone();
            String email = result.getEmail();

            viewHolder.setItemResult(result);
            viewHolder.tvName.setText(name);
            Glide.with(viewHolder.itemView.getContext()).load(result.getPicture().getMedium()).into(viewHolder.imageView);
        }
    }

    public void addUser(Result result){
        userArrayList.add(result);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userArrayList != null ? userArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView imageView;
        Result itemResult;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgViewImage);
            tvName = itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Context c = view.getContext();
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(c, DisplayActivity.class);
                    bundle.putParcelable("person", itemResult);
                    intent.putExtras(bundle);
                    c.startActivity(intent);
                }
            });
        }

        public void setItemResult(Result itemResult){
            this.itemResult = itemResult;
        }
    }
}
