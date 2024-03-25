package com.example.doan.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.doan.Activity.DetailActivity;
import com.example.doan.databinding.ViewholderPopListBinding;
import com.example.doan.model.PopularModel;
import com.example.doan.model.model_2;

import java.util.ArrayList;
import java.util.List;

public class myadapter_2 extends RecyclerView.Adapter<myadapter_2.Viewholder>{
    ArrayList<model_2> items;
    Context context;

//    public void setSearchList(ArrayList<model_2> dataSearchList){
//        this.items=dataSearchList;
//        notifyDataSetChanged();
//    }

    public myadapter_2(ArrayList<model_2> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public myadapter_2.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ViewholderPopListBinding binding=ViewholderPopListBinding.inflate(LayoutInflater.from(context),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter_2.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.txtTensp.setText(items.get(position).getTenSP());
        holder.binding.txtDongia.setText(items.get(position).getDongia()+"M");
        holder.binding.txtDiem.setText(items.get(position).getRate());
        holder.binding.txtDesc.setText(items.get(position).getDescription());

        RequestOptions requestOptions=new RequestOptions();
        requestOptions= requestOptions.transform(new CenterCrop());

        Glide.with(context)
                .load(items.get(position).getHinh().get(0))
                .apply(requestOptions)
                .into(holder.binding.ivHinh);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(context, DetailActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ViewholderPopListBinding binding;

        public Viewholder(ViewholderPopListBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }

    }
}
