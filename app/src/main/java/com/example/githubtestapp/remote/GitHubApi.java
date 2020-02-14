package com.example.githubtestapp.remote;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.example.githubtestapp.remote.pojo.*;

import java.util.List;


public interface GitHubApi {

    @GET("users")
    Observable<List<UserPojo>> getUsersList(@Query("since") int since);

    @GET("users/{login}/repos")
    Observable<List<UserReposPojo>> getUserInfo(@Path("login") String login);

}
