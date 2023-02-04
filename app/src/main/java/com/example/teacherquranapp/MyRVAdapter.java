package com.example.teacherquranapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyRVAdapter  extends RecyclerView.Adapter<MyRVAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name, id, sabq, sabqi, manzil, rollNo;
    Activity activity;

    MyRVAdapter(Activity activity,Context context, ArrayList name, ArrayList id,ArrayList rollNo,  ArrayList sabq,ArrayList sabqi,ArrayList manzil){
        this.activity=activity;
        this.context = context;
        this.name = name;
        this.rollNo=rollNo;
        this.id = id;
        this.sabq = sabq;
        this.sabqi = sabqi;
        this.manzil=manzil;
    }

    @NonNull
    @Override
    public MyRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRVAdapter.MyViewHolder holder, int position) {
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.rollNo_txt.setText(String.valueOf(rollNo.get(position)));
        holder.name_txt.setText(String.valueOf(name.get(position)));
        holder.sabq_txt.setText(String.valueOf(sabq.get(position)));
        holder.sabqi_txt.setText(String.valueOf(sabqi.get(position)));
        holder.manzil_txt.setText(String.valueOf(manzil.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,activity_update.class);
                intent.putExtra("id", String.valueOf(id.get(holder.getAdapterPosition())));
                intent.putExtra("rollNo", String.valueOf(rollNo.get(holder.getAdapterPosition())));
                intent.putExtra("name", String.valueOf(name.get(holder.getAdapterPosition())));
                intent.putExtra("sabq", String.valueOf(sabq.get(holder.getAdapterPosition())));
                intent.putExtra("sabqi", String.valueOf(sabqi.get(holder.getAdapterPosition())));
                intent.putExtra("manzil", String.valueOf(manzil.get(holder.getAdapterPosition())));
                activity.startActivityForResult(intent,1);

            }
        });


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id_txt, rollNo_txt, name_txt, sabq_txt, sabqi_txt, manzil_txt;
        LinearLayout mainLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            id_txt= itemView.findViewById(R.id.TVst_id);
            rollNo_txt=itemView.findViewById(R.id.TVrollNo);
            name_txt= itemView.findViewById(R.id.TVname);
            sabq_txt= itemView.findViewById(R.id.TVsabq);
            sabqi_txt= itemView.findViewById(R.id.TVsabqi);
            manzil_txt= itemView.findViewById(R.id.TVmanzil);
            mainLayout=itemView.findViewById(R.id.mainLayout);


        }
    }
}
