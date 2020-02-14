package com.example.githubtestapp.userInfo;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.githubtestapp.common.DisposableManager;
import com.example.githubtestapp.data.UserInfo;
import com.example.githubtestapp.navigation.GitHubNavigator;
import com.example.githubtestapp.remote.GitHubRepo;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

public class UserInfoViewModel extends ViewModel {


    private GitHubNavigator gitHubNavigator;
    private GitHubRepo gitHubRepo;
    public MutableLiveData<UserInfo> userInfoLiveData;

    @Inject
    public UserInfoViewModel(GitHubNavigator gitHubNavigator, GitHubRepo gitHubRepo) {
        this.gitHubNavigator = gitHubNavigator;
        this.gitHubRepo = gitHubRepo;
        this.userInfoLiveData = new MutableLiveData<>();
    }


    public void initUserInfoLiveData(String login , String imageUrl){
        Disposable disposable = gitHubRepo.getUserRepos(login)
                .subscribe((userReposPojo -> {
                    Log.d("MyLog", userReposPojo.size() + "");
                    UserInfo userInfo = new UserInfo(login , imageUrl , userReposPojo);
                    userInfoLiveData.postValue(userInfo);

                }));
        DisposableManager.add(disposable);
    }

    public void onExitClicked(View v){
        gitHubNavigator.navigateBack();
    }


    @BindingAdapter("android:imageByUrl")
    public static void setImageByUrl(ImageView imageView , String url){
        Picasso.get().load(url).into(imageView);
    }


}
