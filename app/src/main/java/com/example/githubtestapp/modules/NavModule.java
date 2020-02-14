package com.example.githubtestapp.modules;

import androidx.appcompat.app.AppCompatActivity;

import com.example.githubtestapp.navigation.GitHubNavigation;
import com.example.githubtestapp.navigation.GitHubNavigator;

import dagger.Module;
import dagger.Provides;

import static com.example.githubtestapp.common.ScopeAnnotations.*;

@Module
public class NavModule {

    private AppCompatActivity activity;

    public NavModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public AppCompatActivity provideAppCompatActivity(){
        return activity;
    }

    @Provides
    @PerActivity
    public GitHubNavigator provideGitHubNavigation(){
        return new GitHubNavigation(activity);
    }

}
