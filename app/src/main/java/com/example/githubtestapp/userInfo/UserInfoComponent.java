package com.example.githubtestapp.userInfo;

import com.example.githubtestapp.common.ScopeAnnotations.PerUserInfoFragment;
import com.example.githubtestapp.modules.UserInfoModule;

import dagger.Subcomponent;

@PerUserInfoFragment
@Subcomponent(modules = {UserInfoModule.class})
public interface UserInfoComponent {
    void injectUserInfoFragment(UserInfoFragment userInfoFragment);
}
