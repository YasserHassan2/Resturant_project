package com.example.restruant_project.ui.Main;

import android.content.Context;

import com.example.restruant_project.Model.AdvertizeModel;
import com.example.restruant_project.Model.BestSellerModel;
import com.example.restruant_project.Model.Category;
import com.example.restruant_project.R;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {
    MainView view;
    Context context;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public List<AdvertizeModel> GetAdvertizeFromDatabase()
    {
        AdvertizeModel advertizeModel = new AdvertizeModel("Advertize One", R.drawable.back_food);
        AdvertizeModel advertizeModel2 = new AdvertizeModel("Advertize two", R.drawable.back_food);
        AdvertizeModel advertizeModel3 = new AdvertizeModel("Advertize three", R.drawable.back_food);

        List<AdvertizeModel> advertizeModelList = new ArrayList<AdvertizeModel>();
        advertizeModelList.add(advertizeModel);
        advertizeModelList.add(advertizeModel2);
        advertizeModelList.add(advertizeModel3);

        return advertizeModelList;
    }

    public List<Category> GetMainCategoriesFromDatabase()
    {
        Category category = new Category("Burger", R.drawable.coke);
        Category category1 = new Category("Food", R.drawable.sushi);
        Category category2 = new Category("Drink", R.drawable.coke);
        Category category3 = new Category("Pizza", R.drawable.sushi);
        Category category4 = new Category("Pasta", R.drawable.coke);
        Category category5 = new Category("Sandwiches", R.drawable.sushi);
        Category category6 = new Category("Cake", R.drawable.coke);

        List<Category> CategoryList = new ArrayList<Category>();
        CategoryList.add(category);
        CategoryList.add(category1);
        CategoryList.add(category2);
        CategoryList.add(category3);
        CategoryList.add(category4);
        CategoryList.add(category5);
        CategoryList.add(category6);


        return CategoryList;
    }
    public List<BestSellerModel> GetBestSellerFromDatabase()
    {
        BestSellerModel bestSellerModel = new BestSellerModel(R.drawable.burgerfour,"Checken Wraper","Hot Mear, fressh onion and frise,Hot Mear, fressh onion and frise,Hot Mear, fressh onion and frise,Hot Mear, fressh onion and friseHot Mear, fressh onion and friseHot Mear, fressh onion and friseHot Mear, fressh onion and frisev","120");
        BestSellerModel bestSellerModel1 = new BestSellerModel(R.drawable.burgerthre,"Big Mac","Hot Mear, fressh onion and frise","40");
        BestSellerModel bestSellerModel2 = new BestSellerModel(R.drawable.burgerone,"Big Testy","Hot Mear, fressh onion and frise","70");
        BestSellerModel bestSellerModel3 = new BestSellerModel(R.drawable.burgertwo,"Mac Royal","Hot Mear, fressh onion and frise","48");
        BestSellerModel bestSellerModel4 = new BestSellerModel(R.drawable.burgerfour,"Shrempo","Hot Mear, fressh onion and frise","24");

        List<BestSellerModel> bestSellerModels = new ArrayList<BestSellerModel>();
        bestSellerModels.add(bestSellerModel);
        bestSellerModels.add(bestSellerModel1);
        bestSellerModels.add(bestSellerModel2);
        bestSellerModels.add(bestSellerModel3);
        bestSellerModels.add(bestSellerModel4);


        return bestSellerModels;
    }

    public void getAdvertize(){
        view.onGetAdvertize(GetAdvertizeFromDatabase());
    }
    public void getMainCategories(){
        view.onGetCategories(GetMainCategoriesFromDatabase());
    }
    public void getBestSellers(){
        view.onGetBestSeller(GetBestSellerFromDatabase());
    }
}
