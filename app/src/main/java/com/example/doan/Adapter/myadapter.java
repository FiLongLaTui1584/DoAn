package com.example.doan.Adapter;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doan.R;
import com.example.doan.model.model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull final model model) {

        holder.ten.setText(model.getTenSP());
        holder.gia.setText(model.getDongia());
        holder.diem.setText(model.getRate());
        holder.mota.setText(model.getDescription());
        Glide.with(holder.img.getContext()).load(model.getHinh()).into(holder.img);

                //SỬA SẢN PHẨM
                holder.edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                                .setContentHolder(new ViewHolder(R.layout.dialog_update))
                                .setExpanded(true,2500)
                                .create();

                        View myview=dialogPlus.getHolderView();
                        EditText img=myview.findViewById(R.id.uimg);
                        EditText ten=myview.findViewById(R.id.uname);
                        EditText gia=myview.findViewById(R.id.uprice);
                        EditText diem=myview.findViewById(R.id.urate);
                        EditText mota=myview.findViewById(R.id.udescription);
                        Button submit=myview.findViewById(R.id.usubmmit);

                        img.setText(model.getHinh());
                        ten.setText(model.getTenSP());
                        gia.setText(model.getDongia());
                        diem.setText(model.getRate());
                        mota.setText(model.getDescription());

                        dialogPlus.show();


                            submit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Map<String,Object> map=new HashMap<>();
                                    map.put("hinh",img.getText().toString());
                                    map.put("tenSP",ten.getText().toString());
                                    map.put("dongia",gia.getText().toString());
                                    map.put("rate",diem.getText().toString());
                                    map.put("description",mota.getText().toString());

                                    FirebaseDatabase.getInstance().getReference().child("product")
                                            .child(getRef(position).getKey()).updateChildren(map)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    dialogPlus.dismiss();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    dialogPlus.dismiss();
                                                }
                                            });
                                }
                            });
                    }
                });


                //XÓA SẢN PHẨM
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                        builder.setTitle("Xóa sản phẩm");
                        builder.setMessage("Bạn muốn xóa sản phẩm này ?");

                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseDatabase.getInstance().getReference().child("product")
                                        .child(getRef(position).getKey()).removeValue();
                            }
                        });


                        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.show();
                    }
                });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView img, edit, delete;
        TextView ten,gia,diem,mota;
        public myviewholder(@NonNull View itemView){
            super(itemView);

            img=(ImageView) itemView.findViewById(R.id.ivHinh);
            ten=(TextView) itemView.findViewById(R.id.txtTensp);
            gia=(TextView)itemView.findViewById(R.id.txtDongia);
            diem=(TextView)itemView.findViewById(R.id.txtDiem);
            mota=(TextView)itemView.findViewById(R.id.txtDesc);
            edit=(ImageView) itemView.findViewById(R.id.btnEdit);
            delete=(ImageView) itemView.findViewById(R.id.btnDelete);
        }
    }
}
