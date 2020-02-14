package com.example.githubtestapp;

import com.example.githubtestapp.modules.NavModule;
import com.example.githubtestapp.modules.WebModule;
import com.example.githubtestapp.userInfo.UserInfoComponent;
import com.example.githubtestapp.usersList.UsersListComponent;

import dagger.Component;

import static com.example.githubtestapp.common.ScopeAnnotations.*;

@PerActivity
@Component(modules = {NavModule.class, WebModule.class})
public interface AppComponent {
    UsersListComponent createUsersComponent();
    UserInfoComponent createUserInfoComponent();
}
