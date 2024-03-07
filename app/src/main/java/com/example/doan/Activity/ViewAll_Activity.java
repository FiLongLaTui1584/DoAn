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

public class ViewAll_Activity extends AppCompatActivity {

    RecyclerView recyclerViewAll;
    PopularListAdapter popularListAdapter;
    List<PopularModel> arr_all;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        addControls();
        loadData();
    }

    private void loadData() {
        arr_all.add(new PopularModel("iPhone 15 Pro Max",R.drawable.ip15pm,31.79,10,4.9,"iPhone 15 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 15 Plus",R.drawable.ip15plus,23.29,12,4.7,"iPhone 15 Plus là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 14 Pro Max",R.drawable.ip14pm,27.39,10,4.5,"iPhone 14 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPhone 13 Pro Max",R.drawable.ip13pm,22.99,10,4.0,"iPhone 13 Pro Max là điện thoại thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPad Pro M2 2022",R.drawable.ipad_prom2,20.39,12,5.0,"iPad Pro M2 2022 là tablet thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPad Gen 10th 2022",R.drawable.ipad_gen10,14.59,11,4.9,"iPad Gen 10th 2022 là tablet thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPad Air 5 M1 256GB ",R.drawable.ipad_air5_m1,12.29,10,4.8,"iPad Air 5 M1 256GB là tablet thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("iPad Pro M1(2021)",R.drawable.ipad_prom1,18.99,9,4.7,"iPad Pro M1(2021) là tablet thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 15",R.drawable.phone_case1,20.39,12,5.0,"Ốp lưng iPhone 15 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 14",R.drawable.phone_case2,14.59,11,4.9,"Ốp lưng iPhone 14 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 13",R.drawable.phone_case3,12.29,10,4.8,"Ốp lưng iPhone 13 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 12",R.drawable.phone_case4,18.99,9,4.7,"Ốp lưng iPhone 12 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Airpod 2",R.drawable.airpod2,4.79,10,4.9,"Airpod 2 là tai nghe thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("Airpod 3",R.drawable.airpod3,5.29,12,4.7,"Airpod 3 là tai nghe thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("Airpod Pro",R.drawable.airpod_pro,6.39,10,4.5,"Airpod Pro là tai nghe thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
        arr_all.add(new PopularModel("Airpod Max",R.drawable.airpodhd,10.99,10,4.0,"Airpod Max là tai nghe thông minh có màn hình OLED 6,7 inch với tốc độ làm mới 120Hz và bộ xử lý A17 Pro cải tiến của Apple. Nó có thiết lập ba camera với camera chính 48 MP ở mặt sau. Thiết bị này còn được gọi là Apple iPhone 15 Ultra. Nó được phát hành vào ngày 22 tháng 9 năm 2023. Điện thoại chạy trên iOS 17, lên đến iOS 17.3. Nó đi kèm bộ nhớ trong 256GB/512GB/1TB nhưng không có khe cắm thẻ nhớ."));
    }

    private void addControls() {
        recyclerViewAll=findViewById(R.id.view8);


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


        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerViewAll.setLayoutManager(gridLayoutManager);
        arr_all=new ArrayList<>();

        popularListAdapter = new PopularListAdapter(ViewAll_Activity.this,arr_all);
        recyclerViewAll.setAdapter(popularListAdapter);
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

    }

    public void QuayVe(View view){
        finish();
    }
}