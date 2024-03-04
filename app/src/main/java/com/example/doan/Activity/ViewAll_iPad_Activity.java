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

public class ViewAll_iPad_Activity extends AppCompatActivity {

    RecyclerView recyclerViewAll;
    PopularListAdapter popularListAdapter;
    List<PopularModel> arr_all;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_ipad);

        addControls();
        loadData();
    }

    private void loadData() {
        arr_all.add(new PopularModel("iPad Pro M2 2022",R.drawable.ipad_prom2,20.39,12,5.0));
        arr_all.add(new PopularModel("iPad Gen 10th 2022",R.drawable.ipad_gen10,14.59,11,4.9));
        arr_all.add(new PopularModel("iPad Air 5 M1 256GB ",R.drawable.ipad_air5_m1,12.29,10,4.8));
        arr_all.add(new PopularModel("iPad Pro M1(2021)",R.drawable.ipad_prom1,18.99,9,4.7));
        arr_all.add(new PopularModel("iPad Pro M2 2022",R.drawable.ipad_prom2,20.39,12,5.0));
        arr_all.add(new PopularModel("iPad Gen 10th 2022",R.drawable.ipad_gen10,14.59,11,4.9));
        arr_all.add(new PopularModel("iPad Air 5 M1 256GB ",R.drawable.ipad_air5_m1,12.29,10,4.8));
        arr_all.add(new PopularModel("iPad Pro M1(2021)",R.drawable.ipad_prom1,18.99,9,4.7));
        arr_all.add(new PopularModel("iPad Pro M2 2022",R.drawable.ipad_prom2,20.39,12,5.0));
        arr_all.add(new PopularModel("iPad Gen 10th 2022",R.drawable.ipad_gen10,14.59,11,4.9));
        arr_all.add(new PopularModel("iPad Air 5 M1 256GB ",R.drawable.ipad_air5_m1,12.29,10,4.8));
        arr_all.add(new PopularModel("iPad Pro M1(2021)",R.drawable.ipad_prom1,18.99,9,4.7));
    }

    private void addControls() {
        recyclerViewAll=findViewById(R.id.view5);
        searchView=findViewById(R.id.search);


        arr_all=new ArrayList<>();
        popularListAdapter = new PopularListAdapter(ViewAll_iPad_Activity.this,arr_all);
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