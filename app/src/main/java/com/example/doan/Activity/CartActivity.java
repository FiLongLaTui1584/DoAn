package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.doan.Adapter.CartAdapter;
import com.example.doan.R;
import com.example.doan.databinding.ActivityCartBinding;
import com.example.doan.helper.ChangeNumberItemsListener;
import com.example.doan.helper.ManagmentCart;

public class CartActivity extends BaseActivity {
    ActivityCartBinding binding;
    private double tax;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart=new ManagmentCart(this);

        calculatorCart();
        setVarialbe();
        addControls();
    }

    private void addControls() {
        binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.cartView.setAdapter(new CartAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculatorCart();
            }
        }));
    }

    private void setVarialbe() {
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculatorCart() {
        double percentTax=0.02;
        double delivery=0.05;
        tax=(managmentCart.getTotalFee() * percentTax *100.0)/100.0;

        double total=(managmentCart.getTotalFee()+tax+delivery)*100/100;
        double itemTotal=managmentCart.getTotalFee()*100/100;

        binding.totalFeeTxt.setText(itemTotal+"M");
        binding.taxTxt.setText(tax+"M");
        binding.deliveryTxt.setText(delivery+"M");
        binding.TotalTxt.setText(total+"M");
    }

}