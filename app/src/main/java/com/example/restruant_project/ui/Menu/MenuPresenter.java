package com.example.restruant_project.ui.Menu;

import android.content.Context;

import com.example.restruant_project.Model.AdvertizeModel;
import com.example.restruant_project.Model.ProductModel;
import com.example.restruant_project.R;

import java.util.ArrayList;
import java.util.List;

public class MenuPresenter {

    MenuView view;
    Context context;

    public MenuPresenter(MenuView view) {
        this.view = view;
    }

    public List<ProductModel> GetMenuProductsFromDatabase()
    {
        ProductModel productModel = new ProductModel("Checken Warper","alot of words","120",R.drawable.burgerone);
        ProductModel productModel1 = new ProductModel("Big Mac","alot of words,alot of words,alot of words","21",R.drawable.burgertwo);
        ProductModel productModel2 = new ProductModel("Big Tasty","alot of words","340",R.drawable.burgerfour);

        List<ProductModel> productModels = new ArrayList<ProductModel>();
        productModels.add(productModel);
        productModels.add(productModel1);
        productModels.add(productModel2);

        return productModels;
    }

    public void getMenuProducts(){
        view.onGetMenu(GetMenuProductsFromDatabase());
    }
}
