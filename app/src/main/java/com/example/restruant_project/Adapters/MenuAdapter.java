package com.example.restruant_project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.restruant_project.Model.ProductModel;
import com.example.restruant_project.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.RecyclerViewHolders>{

    private List<ProductModel> ProductModelList;
    private Context context;
    CustomItemClickListener listener;
    public MenuAdapter(Context context, List<ProductModel> ProductModelList) {
        this.ProductModelList = ProductModelList;
        this.context = context;
    }

    @Override
    public MenuAdapter.RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent,false);
        final MenuAdapter.RecyclerViewHolders holder = new MenuAdapter.RecyclerViewHolders(layoutView);
        layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getPosition());

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(MenuAdapter.RecyclerViewHolders holder, int position) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(ProductModelList.get(position).getImg())
                .apply(requestOptions)
                .into(holder.ProductModelImage);

        holder.ProductModelName.setText(ProductModelList.get(position).getName());
        holder.ProductModelDesc.setText(ProductModelList.get(position).getDesc());
        holder.ProductModelprice.setText(ProductModelList.get(position).getPrice()+ " EGP");

    }


    //Set method of OnItemClickListener object
    public void setOnItemClickListener(CustomItemClickListener recyclerViewItemClickListner) {
        this.listener = recyclerViewItemClickListner;
    }


    @Override
    public int getItemCount() {
        return this.ProductModelList.size();
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder {

        /**
         * this class contains onclick listener for the recylcer view home
         */

        public TextView ProductModelName,ProductModelDesc,ProductModelprice;
        public ImageView ProductModelImage;
        public int position = 0;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            ProductModelName = (TextView) itemView.findViewById(R.id.tv_productName);
            ProductModelDesc = (TextView) itemView.findViewById(R.id.tv_productDesc);
            ProductModelprice = (TextView) itemView.findViewById(R.id.tv_productPrice);
            ProductModelImage = (ImageView) itemView.findViewById(R.id.img_product);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //When item view is clicked, trigger the itemclicklistener
                    //Because that itemclicklistener is indicated in MainActivity
                    listener.onItemClick(v, position);
                }
            });
        }


    }


}
