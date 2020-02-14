package com.example.githubtestapp.modules;

import com.example.githubtestapp.common.ScopeAnnotations.PerUsersFragment;
import com.example.githubtestapp.navigation.GitHubNavigation;
import com.example.githubtestapp.remote.GitHubRepo;
import com.example.githubtestapp.usersList.UsersListViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersModule {
    @PerUsersFragment
    @Provides
    public UsersListViewModel provideUsersViewModel(GitHubNavigation gitHubNavigation , GitHubRepo gitHubRepo){
        return new UsersListViewModel(gitHubNavigation , gitHubRepo);
    }
}
