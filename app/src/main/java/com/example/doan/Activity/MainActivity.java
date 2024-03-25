package com.example.doan.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.Adapter.PhotoAdapter;
import com.example.doan.Adapter.PopularListAdapter;
import com.example.doan.Adapter.myadapter_2;
import com.example.doan.databinding.ActivityMainBinding;
import com.example.doan.model.Photo;
import com.example.doan.model.PopularModel;
import com.example.doan.R;
import com.example.doan.model.model_2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    ImageButton bell,iphone,ipad,phone_case,headphone,all,cart,user;
    TextView xemtatca;
    ArrayList<model_2> items;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addControls1();
        addEvents();

        viewPager = findViewById(R.id.viewpaper);
        circleIndicator = findViewById(R.id.circle_indicator);

        photoAdapter  = new PhotoAdapter(this, getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

    }

    private void addControls1() {
        DatabaseReference myref=database.getReference("product_1");
        items=new ArrayList<>();

        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue : snapshot.getChildren()){
                        items.add(issue.getValue(model_2.class));
                    }
                    if(!items.isEmpty()){
                        binding.view1.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                        binding.view1.setAdapter(new myadapter_2(items));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bell=findViewById(R.id.bell);
        iphone=findViewById(R.id.image_iphone);
        ipad=findViewById(R.id.image_ipad);
        phone_case=findViewById(R.id.image_phonecase);
        headphone=findViewById(R.id.image_headphone);
        all=findViewById(R.id.image_viewall);
        cart=findViewById(R.id.image_cart);
        user=findViewById(R.id.image_user);
        xemtatca=findViewById(R.id.xemtatca);
    }

    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.img_4));
        list.add(new Photo(R.drawable.img_2));
        list.add(new Photo(R.drawable.img_3));
        list.add(new Photo(R.drawable.img_1));

        return list;
    }

    private void addEvents() {
        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhThongBao();
            }
        });


        iphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {moAllIphone();}
        });

        ipad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {moAllIpad();}
        });

        phone_case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {moAllCase();}
        });

        headphone.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               moAllHeadphone();
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moAll();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moGioHang();
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { moUser(); }
        });

        xemtatca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moAll();
            }
        });

    }

    private void moAll() {
        Intent intent=new Intent(MainActivity.this, ViewAll_Activity.class);
        startActivity(intent);
    }

    private void moAllHeadphone() {
    Intent intent=new Intent(MainActivity.this, ViewAll_Headphone_Activity.class);
       startActivity(intent);
    }

    private void moAllCase() {
        Intent intent=new Intent(MainActivity.this, ViewAll_Case_Activity.class);
        startActivity(intent);
    }

    private void moUser() {
        Intent intent=new Intent(MainActivity.this, UserActivity.class);
        startActivity(intent);
    }

    private void moAllIpad() {
        Intent intent=new Intent(MainActivity.this, ViewAll_iPad_Activity.class);
        startActivity(intent);
    }

    private void moGioHang() {
        Intent intent=new Intent(MainActivity.this,CartActivity.class);
        startActivity(intent);
    }

    private void moAllIphone() {
        Intent intent=new Intent(MainActivity.this, ViewAll_iPhone_Activity.class);
        startActivity(intent);
    }

    private void moManHinhThongBao() {
        Intent intent=new Intent(MainActivity.this,ThongBao_Activity.class);
        startActivity(intent);
    }

//    private void addControls() {
//        searchView=findViewById(R.id.search);
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                searchList(newText);
//                return true;
//            }
//        });
//    }


//    private void searchList(String text) {
//        ArrayList<model_2> dataSearchList =new ArrayList<>();
//        for (model_2 data: items){
//            if(data.getTenSP().toLowerCase().contains(text.toLowerCase())){
//                dataSearchList.add(data);
//            }
//        }
//
//        if(dataSearchList.isEmpty()){
//            Toast.makeText(this,"Không tìm thấy",Toast.LENGTH_SHORT).show();
//        } else {
//            myadapter_2.setSearchList(dataSearchList);
//        }
//
//    }
}