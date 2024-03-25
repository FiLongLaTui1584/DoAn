package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.doan.Adapter.SliderAdapter;
import com.example.doan.R;
import com.example.doan.databinding.ActivityDetailBinding;
import com.example.doan.databinding.ActivityMainBinding;
import com.example.doan.helper.ManagmentCart;
import com.example.doan.model.PopularModel;
import com.example.doan.model.SliderItems;
import com.example.doan.model.SliderItems;
import com.example.doan.model.model_2;

import java.util.ArrayList;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private model_2 object;
    private int numberOrder=1;
    private ManagmentCart managmentCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart=new ManagmentCart(this);

        getBundles();
        getSliderHinh();


    }

    private void getSliderHinh() {
        ArrayList<SliderItems> sliderItems=new ArrayList<>();
        for (int i = 0; i < object.getHinh().size(); i++) {
            sliderItems.add(new SliderItems(object.getHinh().get(i)));
        }
        binding.viewpageSlider.setAdapter(new SliderAdapter(sliderItems,binding.viewpageSlider));
        binding.viewpageSlider.setClipToPadding(false);
        binding.viewpageSlider.setClipChildren(false);
        binding.viewpageSlider.setOffscreenPageLimit(1);
        binding.viewpageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
    }

    private void getBundles() {
        object=(model_2) getIntent().getSerializableExtra("object");
        binding.txtTensp.setText(object.getTenSP());
        binding.txtDongia.setText(object.getDongia()+"M");
        binding.txtDiem.setText(object.getRate());
        binding.txtDesc.setText(object.getDescription());


        binding.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberinCart(numberOrder);
                managmentCart.insertItem(object);
            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}