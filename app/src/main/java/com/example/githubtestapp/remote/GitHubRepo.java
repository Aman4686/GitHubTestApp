package com.example.githubtestapp.remote;

import com.example.githubtestapp.App;
import com.example.githubtestapp.remote.pojo.UserReposPojo;
import com.example.githubtestapp.remote.pojo.UserPojo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GitHubRepo {

        public Observable<List<UserPojo>> getListOfUser(int since) {
            return App.getGitHubApi().getUsersList(since)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }

        public Observable<List<UserReposPojo>> getUserRepos(String login) {
        return App.getGitHubApi().getUserInfo(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        }
}
