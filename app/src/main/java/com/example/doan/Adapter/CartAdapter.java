package com.example.doan.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.doan.databinding.ViewholderCartBinding;
import com.example.doan.helper.ChangeNumberItemsListener;
import com.example.doan.helper.ManagmentCart;
import com.example.doan.model.model_2;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {

    ArrayList<model_2> listItemSelected;
    ChangeNumberItemsListener changeNumberItemsListener;
    private ManagmentCart managmentCart;

    public CartAdapter(ArrayList<model_2> listItemSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listItemSelected = listItemSelected;
        this.changeNumberItemsListener = changeNumberItemsListener;
        managmentCart=new ManagmentCart(context);
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderCartBinding binding=ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.titleTxt.setText(listItemSelected.get(position).getTenSP());
        holder.binding.feeEachItem.setText(listItemSelected.get(position).getDongia()+"M");
        holder.binding.totalEachItem.setText((listItemSelected.get(position).getNumberinCart() * listItemSelected.get(position).getDongia())+"M");
        holder.binding.numberItemTxt.setText(String.valueOf(listItemSelected.get(position).getNumberinCart()));

        RequestOptions requestOptions=new RequestOptions();
        requestOptions=requestOptions.transform(new CenterCrop());

        Glide.with(holder.itemView.getContext())
                .load(listItemSelected.get(position).getHinh().get(0))
                .apply(requestOptions)
                .into(holder.binding.pic);



        holder.binding.plusCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managmentCart.plusItem(listItemSelected, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });
        holder.binding.minusCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managmentCart.minusItem(listItemSelected, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItemSelected.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ViewholderCartBinding binding;
        private Viewholder(ViewholderCartBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
