package com.example.restruant_project.ui.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.restruant_project.Adapters.BestSellerAdapter;
import com.example.restruant_project.Adapters.CustomItemClickListener;
import com.example.restruant_project.Adapters.MainCategoryAdapter;
import com.example.restruant_project.Adapters.MenuAdapter;
import com.example.restruant_project.Model.ProductModel;
import com.example.restruant_project.R;
import com.example.restruant_project.ui.Details.DetailsActivity;
import com.example.restruant_project.ui.Main.MainActivity;

import java.util.List;

public class MenuActivity extends AppCompatActivity implements MenuView{
    private MenuAdapter menuAdapter;
    RecyclerView recyclerView;
    MenuPresenter menuPresenter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.recyclerView);

        menuPresenter = new MenuPresenter(this);
        menuPresenter.getMenuProducts();



    }

    @Override
    public void onGetMenu(List<ProductModel> productList) {
        menuAdapter = new MenuAdapter(this,productList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(menuAdapter);

        Log.d("MenuActivity ", "onGetMenu: list Size : "+ productList.size());



        menuAdapter.setOnItemClickListener(new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                intent = new Intent(MenuActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
