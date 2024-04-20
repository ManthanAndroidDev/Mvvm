package com.example.mvvm.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.Adapter.NewsAdapter;
import com.example.mvvm.R;
import com.example.mvvm.ViewModel.NewViewModel;

import java.util.ArrayList;

public class NewsDetailActivity extends AppCompatActivity {

    NewViewModel newViewModel;

    NewsAdapter newsAdapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        recyclerView = findViewById(R.id.idRVNews);

        newsAdapter = new NewsAdapter(new ArrayList<>());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NewsDetailActivity.this, RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(newsAdapter);

        newViewModel = new ViewModelProvider(this).get(NewViewModel.class);

        newViewModel.getNews();

        newViewModel.liveData().observe(this, newsResponse -> {

            newsAdapter.setList(newsResponse.getArticles());
            newsAdapter.notifyDataSetChanged();
        });


    }
}