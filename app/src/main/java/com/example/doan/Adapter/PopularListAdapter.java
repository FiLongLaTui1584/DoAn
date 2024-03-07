package com.example.doan.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.Activity.DetailActivity;
import com.example.doan.Activity.MainActivity;
import com.example.doan.R;
import com.example.doan.model.PopularModel;

import java.util.ArrayList;
import java.util.List;

public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.ViewHolder> {
    private Context context;
    private List<PopularModel> arr_SanPham;

    public PopularListAdapter(Context context, List<PopularModel> arr_SanPham) {
        this.context = context;
        this.arr_SanPham = arr_SanPham;
    }

    public void setSearchList(List<PopularModel> dataSearchList){
        this.arr_SanPham=dataSearchList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewSanpham=layoutInflater.inflate(R.layout.viewholder_pop_list,parent,false);
        ViewHolder viewHolderSP=new ViewHolder(viewSanpham);
        return viewHolderSP;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularListAdapter.ViewHolder holder, int position) {
        PopularModel popularModel=arr_SanPham.get(position);
        holder.ivHinh.setImageResource(popularModel.getIvhinh());
        holder.txtTensp.setText(popularModel.getTxtTensp());
        holder.txtDongia.setText(popularModel.getTxtDongia()+"M");
        holder.txtDanhgia.setText(popularModel.getTxtDanhgia()+"");
        holder.txtDiem.setText(popularModel.getTxtDiem()+"");
        holder.txtDesc.setText(popularModel.getTxtDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("ivHinh", arr_SanPham.get(holder.getAdapterPosition()).getIvhinh());
                intent.putExtra("txtTensp", arr_SanPham.get(holder.getAdapterPosition()).getTxtTensp());
                intent.putExtra("txtDongia", arr_SanPham.get(holder.getAdapterPosition()).getTxtDongia()+"M");
                intent.putExtra("txtDanhgia", arr_SanPham.get(holder.getAdapterPosition()).getTxtDanhgia()+"");
                intent.putExtra("txtDiem", arr_SanPham.get(holder.getAdapterPosition()).getTxtDiem()+"");
                intent.putExtra("txtDesc", arr_SanPham.get(holder.getAdapterPosition()).getTxtDesc());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr_SanPham.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivHinh;
        TextView txtTensp, txtDongia, txtDanhgia, txtDiem, txtDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHinh=itemView.findViewById(R.id.ivHinh);
            txtTensp=itemView.findViewById(R.id.txtTensp);
            txtDongia=itemView.findViewById(R.id.txtDongia);
            txtDanhgia=itemView.findViewById(R.id.txtDanhgia);
            txtDiem=itemView.findViewById(R.id.txtDiem);
            txtDesc=itemView.findViewById(R.id.txtDesc);
        }
    }
}
