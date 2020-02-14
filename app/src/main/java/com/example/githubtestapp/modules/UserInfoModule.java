package com.example.githubtestapp.modules;

import com.example.githubtestapp.common.ScopeAnnotations.PerUserInfoFragment;
import com.example.githubtestapp.navigation.GitHubNavigation;
import com.example.githubtestapp.remote.GitHubRepo;
import com.example.githubtestapp.userInfo.UserInfoViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class UserInfoModule {

    @PerUserInfoFragment
    @Provides
    public UserInfoViewModel provideUserInfoViewModel(GitHubNavigation gitHubNavigation , GitHubRepo gitHubRepo){
        return new UserInfoViewModel(gitHubNavigation , gitHubRepo);
    }
}
