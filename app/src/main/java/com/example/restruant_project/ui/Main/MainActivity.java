package com.example.restruant_project.ui.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.restruant_project.Adapters.BestSellerAdapter;
import com.example.restruant_project.Adapters.CustomItemClickListener;
import com.example.restruant_project.Adapters.MainCategoryAdapter;
import com.example.restruant_project.Adapters.SliderAdapter;
import com.example.restruant_project.Model.AdvertizeModel;
import com.example.restruant_project.Model.BestSellerModel;
import com.example.restruant_project.Model.Category;
import com.example.restruant_project.R;
import com.example.restruant_project.ui.Menu.MenuActivity;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
    SliderView sliderView;
    private SliderAdapter adapter;
    private MainCategoryAdapter mainCategoryAdapter;
    private BestSellerAdapter bestSellerAdapter;
    RecyclerView recyclerView,recyclerView_bestSeller;
    String TAG = "MainActivity";
    Intent intent;

    StaggeredGridLayoutManager _sGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView_bestSeller = findViewById(R.id.recyclerView_bestSeller);
        mainPresenter.getAdvertize();
        mainPresenter.getMainCategories();
        mainPresenter.getBestSellers();
    }

    @Override
    public void onGetAdvertize(List<AdvertizeModel> advertizeModels) {

        sliderView = findViewById(R.id.imageSlider);

        adapter = new SliderAdapter(this);
        sliderView.setSliderAdapter(adapter);
        adapter.renewItems(advertizeModels);
        sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
    }

    @Override
    public void onGetCategories(List<Category> categoryList) {
        mainCategoryAdapter = new MainCategoryAdapter(this,categoryList);
        //horizontal recyclerView orign
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainCategoryAdapter);
        Log.d(TAG, "onGetCategories: size : " + categoryList.size());

        mainCategoryAdapter.setOnItemClickListener(new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });




    }

    @Override
    public void onGetBestSeller(List<BestSellerModel> bestSellerModelsList) {
        bestSellerAdapter = new BestSellerAdapter(this,bestSellerModelsList);

        _sGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView_bestSeller.setLayoutManager(_sGridLayoutManager);
        recyclerView_bestSeller.stopNestedScroll();
        recyclerView_bestSeller.setAdapter(bestSellerAdapter);

        bestSellerAdapter.setOnItemClickListener(new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
