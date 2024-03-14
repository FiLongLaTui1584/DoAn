package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan.Adapter.PopularListAdapter;
import com.example.doan.model.PopularModel;
import com.example.doan.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    ImageButton bell,iphone,ipad,phone_case,headphone,all,cart,user;
    TextView xemtatca;
    SearchView searchView;
    RecyclerView recyclerViewSP;
    PopularListAdapter popularListAdapter;
    ArrayList<PopularModel> arr_sanpham;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
        loadData();

        viewPager = findViewById(R.id.viewpaper);
        circleIndicator = findViewById(R.id.circle_indicator);

        photoAdapter  = new PhotoAdapter(this, getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

    }

    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.image1));
        list.add(new Photo(R.drawable.image2));
        list.add(new Photo(R.drawable.image3));
        list.add(new Photo(R.drawable.image4));

        return list;
    }

    private void loadData() {
        arr_sanpham.add(new PopularModel("iPhone 15 Pro Max",R.drawable.ip15pm,31.79,10,4.9,"iPhone 15 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_sanpham.add(new PopularModel("iPad Pro M2 2022",R.drawable.ipad_prom2,20.39,12,5.0,"iPad Pro M2 2022 là tablet thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_sanpham.add(new PopularModel("iPhone 14 Pro Max",R.drawable.ip14pm,27.39,10,4.5,"iPhone 14 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_sanpham.add(new PopularModel("iPhone 13 Pro Max",R.drawable.ip13pm,22.99,10,4.0,"iPhone 13 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
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

    private void addControls() {
        bell=findViewById(R.id.bell);
        iphone=findViewById(R.id.image_iphone);
        ipad=findViewById(R.id.image_ipad);
        phone_case=findViewById(R.id.image_phonecase);
        headphone=findViewById(R.id.image_headphone);
        all=findViewById(R.id.image_viewall);
        cart=findViewById(R.id.image_cart);
        user=findViewById(R.id.image_user);
        xemtatca=findViewById(R.id.xemtatca);



        searchView=findViewById(R.id.search);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });



        recyclerViewSP=findViewById(R.id.view1);
        arr_sanpham=new ArrayList<>();
        popularListAdapter=new PopularListAdapter(this,arr_sanpham);
        recyclerViewSP.setAdapter(popularListAdapter);
        recyclerViewSP.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }


    private void searchList(String text) {
        ArrayList<PopularModel> dataSearchList =new ArrayList<>();
        for (PopularModel data: arr_sanpham){
            if(data.getTxtTensp().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }

        if(dataSearchList.isEmpty()){
            Toast.makeText(this,"Không tìm thấy",Toast.LENGTH_SHORT).show();
        } else {
            popularListAdapter.setSearchList(dataSearchList);
        }

    }
}