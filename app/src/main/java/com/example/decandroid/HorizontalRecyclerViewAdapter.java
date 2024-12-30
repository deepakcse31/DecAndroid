package com.example.decandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {
    private List<MyList> myLists;
    private Context context;


    public HorizontalRecyclerViewAdapter(List<MyList> myLists, Context context){
        this.myLists=myLists;
        this.context=context;
    }
    @NonNull
    @Override
    public HorizontalRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItem=layoutInflater.inflate(R.layout.horizontal_rv_item,parent,false);
        HorizontalRecyclerViewAdapter.ViewHolder viewHolder=new HorizontalRecyclerViewAdapter.ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tvname.setText(myLists.get(position).name);
        holder.tvdesc.setText(myLists.get(position).des);


    }

    @Override
    public int getItemCount() {
        return myLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivimg;
        TextView tvname;
        TextView tvdesc;


        public ViewHolder(View itemView){
            super(itemView);
            this.ivimg=itemView.findViewById(R.id.ivimage);
            this.tvname=itemView.findViewById(R.id.tvname);
            this.tvdesc=itemView.findViewById(R.id.tvdesc);
        }
    }
}
