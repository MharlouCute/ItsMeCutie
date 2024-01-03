package com.example.debtcollection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private Context context;
    private ArrayList id, name, money , location, date;

    public MyAdapter(Context context, ArrayList id, ArrayList name, ArrayList money, ArrayList location, ArrayList date) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.money = money;
        this.location = location;
        this.date = date;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.name.setText(String.valueOf(name.get(position)));
        holder.money.setText(String.valueOf(money.get(position)));
        holder.location.setText(String.valueOf(location.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, name,money,location,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tId);
            name = itemView.findViewById(R.id.tName);
            money = itemView.findViewById(R.id.tMoney);
            location = itemView.findViewById(R.id.tLocation);
            date = itemView.findViewById(R.id.tdateR);

        }
    }
}
