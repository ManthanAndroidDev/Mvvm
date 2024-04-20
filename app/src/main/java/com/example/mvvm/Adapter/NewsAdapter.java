package com.example.mvvm.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.Model.Articles;
import com.example.mvvm.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<Articles> articles;

    public NewsAdapter(List<Articles> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item, parent, false);

        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {

        Articles articles1 = articles.get(position);

        holder.titleTxt.setText(articles1.getTitle());
        holder.DescTxt.setText(articles1.getDescription());
        Picasso.get().load(articles1.getUrlToImage()).into(holder.PictureImg);

    }

    @Override
    public int getItemCount() {
        if(articles!= null){
            return articles.size();
        }else
            return 0;
    }

    public void setList(List<Articles> articles) {

        this.articles = articles;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTxt, DescTxt;
        ImageView PictureImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTxt = itemView.findViewById(R.id.idTVNewsHeading);
            DescTxt = itemView.findViewById(R.id.idTVSubTitle);
            PictureImg = itemView.findViewById(R.id.idIVNews);

        }
    }
}
