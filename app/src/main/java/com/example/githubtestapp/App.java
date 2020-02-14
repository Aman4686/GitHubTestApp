package com.example.githubtestapp;

import android.app.Application;

import com.example.githubtestapp.remote.GitHubApi;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static final String GITHUB_BASE_URL = "https://api.github.com/";
    private static GitHubApi gitHubApi;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(GITHUB_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gitHubApi = retrofit.create(GitHubApi.class);
    }

    public static GitHubApi getGitHubApi() {
        return gitHubApi;
    }
}
