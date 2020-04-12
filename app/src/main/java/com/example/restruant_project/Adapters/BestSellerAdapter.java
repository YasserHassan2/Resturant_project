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
import com.example.restruant_project.Model.BestSellerModel;
import com.example.restruant_project.Model.BestSellerModel;
import com.example.restruant_project.R;

import java.util.List;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.RecyclerViewHolders>{

    private List<BestSellerModel> BestSellerModelList;
    private Context context;
    CustomItemClickListener listener;
    public BestSellerAdapter(Context context, List<BestSellerModel> BestSellerModelList) {
        this.BestSellerModelList = BestSellerModelList;
        this.context = context;
    }

    @Override
    public BestSellerAdapter.RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.best_seller_row, parent,false);
        final BestSellerAdapter.RecyclerViewHolders holder = new BestSellerAdapter.RecyclerViewHolders(layoutView);
        layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getPosition());

            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(BestSellerAdapter.RecyclerViewHolders holder, int position) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(BestSellerModelList.get(position).getImg())
                .apply(requestOptions)
                .into(holder.BestSellerModelImage);

        holder.BestSellerModelName.setText(BestSellerModelList.get(position).getName());
        holder.BestSellerModelDesc.setText(BestSellerModelList.get(position).getDescription());
        holder.BestSellerModelprice.setText(BestSellerModelList.get(position).getPrice()+ " EGP");

    }


    //Set method of OnItemClickListener object
    public void setOnItemClickListener(CustomItemClickListener recyclerViewItemClickListner) {
        this.listener = recyclerViewItemClickListner;
    }


    @Override
    public int getItemCount() {
        return this.BestSellerModelList.size();
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder {

        /**
         * this class contains onclick listener for the recylcer view home
         */

        public TextView BestSellerModelName,BestSellerModelDesc,BestSellerModelprice;
        public ImageView BestSellerModelImage;
        public int position = 0;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            BestSellerModelName = (TextView) itemView.findViewById(R.id.tv_bestseller_name);
            BestSellerModelDesc = (TextView) itemView.findViewById(R.id.tv_bestseller_desc);
            BestSellerModelprice = (TextView) itemView.findViewById(R.id.tv_bestseller_price);
            BestSellerModelImage = (ImageView) itemView.findViewById(R.id.img_bestSeller);


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
