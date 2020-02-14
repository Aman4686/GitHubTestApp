package com.example.githubtestapp.usersList;

import com.example.githubtestapp.common.ScopeAnnotations.PerUsersFragment;
import com.example.githubtestapp.modules.UsersModule;

import dagger.Subcomponent;

@PerUsersFragment
@Subcomponent(modules = {UsersModule.class})
public interface UsersListComponent {
    void injectUsersFragment(UsersListFragment usersListFragment);
}
