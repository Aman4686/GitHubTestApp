package com.example.githubtestapp.data;

import com.example.githubtestapp.remote.pojo.UserReposPojo;

import java.util.List;

public class UserInfo {

    private String login;
    private String imageUrl;
    private List<UserReposPojo> userReposPojoList;

    public UserInfo(String login, String imageUrl, List<UserReposPojo> userReposPojoList) {
        this.login = login;
        this.imageUrl = imageUrl;
        this.userReposPojoList = userReposPojoList;
    }

    public String getLogin() {
        return login;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<UserReposPojo> getUserReposPojoList() {
        return userReposPojoList;
    }

    public void setUserReposPojoList(List<UserReposPojo> userReposPojoList) {
        this.userReposPojoList = userReposPojoList;
    }
}
