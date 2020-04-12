package com.example.restruant_project.ui.Main;

import com.example.restruant_project.Model.AdvertizeModel;
import com.example.restruant_project.Model.BestSellerModel;
import com.example.restruant_project.Model.Category;

import java.util.List;

public interface MainView {

    void onGetAdvertize(List<AdvertizeModel> advertizeModels);

    void onGetCategories(List<Category> categoryList);

    void onGetBestSeller(List<BestSellerModel> bestSellerModelsList);
}
