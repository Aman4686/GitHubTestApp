package com.example.githubtestapp.modules;

import com.example.githubtestapp.remote.GitHubRepo;

import dagger.Module;
import dagger.Provides;

@Module
public class WebModule {

    @Provides
    public GitHubRepo provideGitHubRepo(){
        return new GitHubRepo();
    }

}
