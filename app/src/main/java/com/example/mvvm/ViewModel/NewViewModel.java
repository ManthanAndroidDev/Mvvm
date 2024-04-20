package com.example.mvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.Model.NewsResponse;
import com.example.mvvm.Network.ApiInterface;
import com.example.mvvm.Network.RetrofitBuilder;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewViewModel extends AndroidViewModel {

    MutableLiveData<NewsResponse> mutableLiveData;
    Application application;

    public NewViewModel(@NonNull Application application) {
        super(application);

        this.application = application;
        mutableLiveData = new MutableLiveData<>();
    }
    public LiveData<NewsResponse> liveData(){

        return mutableLiveData;
    };

    public void getNews(){

        ApiInterface apiInterface = RetrofitBuilder.getInstance(application).getApi();
        apiInterface.newResponse("e35908d6144a427696a6abc54e81a7ce")
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {

                        System.out.println("twst = "+new Gson().toJson(response.body()));
                        mutableLiveData.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {

                    }
                });

    }
}
