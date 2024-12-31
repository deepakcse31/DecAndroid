package com.example.decandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
  //  private List<MyList> myLists;
    private Context context;
    private List<Repository> listData;


    public RecyclerViewAdapter(List<Repository> listData, Context context){
        this.listData=listData;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItem=layoutInflater.inflate(R.layout.recyclerview_list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
    holder.tvname.setText(listData.get(position).getName());
    holder.tvdesc.setText(listData.get(position).getFull_name());

        Glide.with(context)
                .load(listData.get(position).getOwner().getAvatar_url())
                .into(holder.ivimg);

    }

    @Override
    public int getItemCount() {
        return listData.size();
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
