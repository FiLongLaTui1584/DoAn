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

public class ViewAll_Case_Activity extends AppCompatActivity {

    RecyclerView recyclerViewAll;
    PopularListAdapter popularListAdapter;
    List<PopularModel> arr_all;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_case);

        addControls();
        loadData();
    }

    private void loadData() {
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 15",R.drawable.phone_case1,20.39,12,5.0,"Ốp lưng iPhone 15 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 14",R.drawable.phone_case2,14.59,11,4.9,"Ốp lưng iPhone 14 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 13",R.drawable.phone_case3,12.29,10,4.8,"Ốp lưng iPhone 13 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 12",R.drawable.phone_case4,18.99,9,4.7,"Ốp lưng iPhone 12 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 15",R.drawable.phone_case1,20.39,12,5.0,"Ốp lưng iPhone 15 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 14",R.drawable.phone_case2,14.59,11,4.9,"Ốp lưng iPhone 14 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 13",R.drawable.phone_case3,12.29,10,4.8,"Ốp lưng iPhone 13 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 12",R.drawable.phone_case4,18.99,9,4.7,"Ốp lưng iPhone 12 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 15",R.drawable.phone_case1,20.39,12,5.0,"Ốp lưng iPhone 15 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 14",R.drawable.phone_case2,14.59,11,4.9,"Ốp lưng iPhone 14 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 13",R.drawable.phone_case3,12.29,10,4.8,"Ốp lưng iPhone 13 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
        arr_all.add(new PopularModel("Bao da, ốp lưng cho iPhone 12",R.drawable.phone_case4,18.99,9,4.7,"Ốp lưng iPhone 12 hỗ trợ sạc Magsafe có kiểu dáng ốp khít với nhiều màu sắc cho người dùng lựa chọn từ hồng, xanh, đen đến trong suốt. Ốp có thể sạc không dây thông qua vòng tròn nam châm từ tính. Cùng với đó, mẫu ốp iPhone 15 Pro Max còn mang lại khả năng chống trầy, bảo vệ điện thoại hiệu quả."));
    }

    private void addControls() {
        recyclerViewAll=findViewById(R.id.view6);
        searchView=findViewById(R.id.search);


        arr_all=new ArrayList<>();
        popularListAdapter = new PopularListAdapter(ViewAll_Case_Activity.this,arr_all);
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