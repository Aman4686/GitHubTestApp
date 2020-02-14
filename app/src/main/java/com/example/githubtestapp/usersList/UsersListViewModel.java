package com.example.githubtestapp.usersList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubtestapp.common.DisposableManager;
import com.example.githubtestapp.navigation.GitHubNavigator;
import com.example.githubtestapp.remote.GitHubRepo;
import com.example.githubtestapp.remote.pojo.UserPojo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class UsersListViewModel extends ViewModel {

    private GitHubNavigator gitHubNavigator;
    private GitHubRepo gitHubRepo;
    public MutableLiveData<List<UserPojo>> userListLiveData;
    private Disposable disposable;
    @Inject
    public UsersListViewModel(GitHubNavigator gitHubNavigator , GitHubRepo gitHubRepo) {
        this.gitHubNavigator = gitHubNavigator;
        this.gitHubRepo = gitHubRepo;
        this.userListLiveData = new MutableLiveData<>();
        refreshUserList(0);


    }

    public void refreshUserList(int since){
        disposable = gitHubRepo.getListOfUser(since)
                .subscribe(userList -> userListLiveData.setValue(userList));
        DisposableManager.add(disposable);
    }



    public void navigateToUserInfo(String login, String imageUrl){
        gitHubNavigator.navigateUsersToUserInfo(login ,imageUrl);
    }



}
