package com.example.bloodbank;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class Adap extends RecyclerView.Adapter<Adap.MyViewHolder> {

    ArrayList<Modeld> mList;
    Context context;

    public Adap(Context context , ArrayList<Modeld> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adap.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemd , parent ,false);
        return new Adap.MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull Adap.MyViewHolder holder, int position) {
        Modeld modeld=mList.get(position);
        holder.name.setText(modeld.getName());
        holder.fname.setText(modeld.getFname());
        holder.age.setText(modeld.getAge());
        holder.phone.setText(modeld.getPhone());
        holder.address.setText(modeld.getAddress());
        holder.statuss.setText(modeld.getStatuss());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView   name,fname ,age ,phone ,address ,statuss;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.dName);
            fname = itemView.findViewById(R.id.dbFname);
            age = itemView.findViewById(R.id.dAge);
            phone=itemView.findViewById(R.id.dPhone);
            address = itemView.findViewById(R.id.dAddress);
            statuss = itemView.findViewById(R.id.dStatus);
        }
    }
}

