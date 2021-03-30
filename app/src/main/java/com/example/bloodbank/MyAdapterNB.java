package com.example.bloodbank;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class MyAdapterNB extends RecyclerView.Adapter<MyAdapterNB.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapterNB(Context context , ArrayList<Model> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.pname.setText(model.getPname());
        holder.cnics.setText(model.getCnics());
        holder.spiners.setText(model.getSpiners());

        holder.phone.setText(model.getPhone());
        holder.hnames.setText(model.getHnames());
        holder.anames.setText(model.getAnames());
        holder.aphones.setText(model.getAphones());

        holder.status.setText(model.getStatus());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView  pname,  cnics,  spiners,  phone,  hnames,  anames,  aphones, status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            pname = itemView.findViewById(R.id.nName);
            cnics = itemView.findViewById(R.id.nCNIC);
            spiners = itemView.findViewById(R.id.nBlood);
            phone=itemView.findViewById(R.id.nPhone);
            hnames = itemView.findViewById(R.id.nHos);
            anames = itemView.findViewById(R.id.nAname);
            aphones=itemView.findViewById(R.id.nAphone);
            status=itemView.findViewById(R.id.nStatus);
        }
    }
}

