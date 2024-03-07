package com.example.doan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.doan.Adapter.PopularListAdapter;
import com.example.doan.R;
import com.example.doan.model.PopularModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAll_iPhone_Activity extends AppCompatActivity {

    RecyclerView recyclerViewAll;
    PopularListAdapter popularListAdapter;
    List<PopularModel> arr_all;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_iphone);

        addControls();
        loadData();
    }

    private void loadData() {
        arr_all.add(new PopularModel("iPhone 15 Pro Max",R.drawable.ip15pm,31.79,10,4.9,"iPhone 15 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 15 Plus",R.drawable.ip15plus,23.29,12,4.7,"iPhone 15 Plus là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 14 Pro Max",R.drawable.ip14pm,27.39,10,4.5,"iPhone 14 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 13 Pro Max",R.drawable.ip13pm,22.99,10,4.0,"iPhone 13 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 15 Pro Max",R.drawable.ip15pm,31.79,10,4.9,"iPhone 15 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 15 Plus",R.drawable.ip15plus,23.29,12,4.7,"iPhone 15 Plus là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 14 Pro Max",R.drawable.ip14pm,27.39,10,4.5,"iPhone 14 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 13 Pro Max",R.drawable.ip13pm,22.99,10,4.0,"iPhone 13 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 15 Pro Max",R.drawable.ip15pm,31.79,10,4.9,"iPhone 15 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 15 Plus",R.drawable.ip15plus,23.29,12,4.7,"iPhone 15 Plus là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 14 Pro Max",R.drawable.ip14pm,27.39,10,4.5,"iPhone 14 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 13 Pro Max",R.drawable.ip13pm,22.99,10,4.0,"iPhone 13 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
    }

    private void addControls() {
        recyclerViewAll=findViewById(R.id.view4);
        searchView=findViewById(R.id.search);


        arr_all=new ArrayList<>();
        popularListAdapter = new PopularListAdapter(ViewAll_iPhone_Activity.this,arr_all);
        recyclerViewAll.setAdapter(popularListAdapter);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerViewAll.setLayoutManager(gridLayoutManager);

        //SEARCH
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
    }

    private void searchList(String text) {
        ArrayList<PopularModel> dataSearchList =new ArrayList<>();
        for (PopularModel data: arr_all){
            if(data.getTxtTensp().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if(dataSearchList.isEmpty()){
            Toast.makeText(this,"Không tìm thấy",Toast.LENGTH_SHORT).show();
        } else {
            popularListAdapter.setSearchList(dataSearchList);
        }

    }//SEARCH

    public void QuayVe(View view){
        finish();
    }
}