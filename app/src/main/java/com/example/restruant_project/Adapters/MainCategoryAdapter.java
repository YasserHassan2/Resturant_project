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
import com.example.restruant_project.Model.Category;
import com.example.restruant_project.R;

import java.util.List;

public class MainCategoryAdapter  extends RecyclerView.Adapter<MainCategoryAdapter.RecyclerViewHolders>{

    private List<Category> categoryList;
    private Context context;
    CustomItemClickListener listener;
    public MainCategoryAdapter(Context context, List<Category> categoryList) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_item, parent,false);
        final RecyclerViewHolders holder = new RecyclerViewHolders(layoutView);
        layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getPosition());

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(categoryList.get(position).getImage())
                .apply(requestOptions)
                .into(holder.CategoryImage);

        holder.CategoryName.setText(categoryList.get(position).getName());

    }


    //Set method of OnItemClickListener object
    public void setOnItemClickListener(CustomItemClickListener recyclerViewItemClickListner) {
        this.listener = recyclerViewItemClickListner;
    }


    @Override
    public int getItemCount() {
        return this.categoryList.size();
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder {

        /**
         * this class contains onclick listener for the recylcer view home
         */

        public TextView CategoryName;
        public ImageView CategoryImage;
        public int position = 0;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            CategoryName = (TextView) itemView.findViewById(R.id.tv_cat_title);
            CategoryImage = (ImageView) itemView.findViewById(R.id.cat_icon);


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
