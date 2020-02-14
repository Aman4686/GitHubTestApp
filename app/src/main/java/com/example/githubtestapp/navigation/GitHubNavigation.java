package com.example.githubtestapp.navigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.githubtestapp.R;

import javax.inject.Inject;

public class GitHubNavigation implements GitHubNavigator{


    private NavController navController;

    @Inject
    public GitHubNavigation(AppCompatActivity activity) {
        this.navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
    }

    @Override
    public void navigateBack() {
        navController.popBackStack();
    }

    @Override
    public void navigateUsersToUserInfo(String login, String imageUrl) {
        Bundle bundle = new Bundle();
        bundle.putString("USER_LOGIN" , login);
        bundle.putString("USER_IMAGE_URL" , imageUrl);
        navController.navigate(R.id.action_usersFragment_to_userInfoFragment , bundle);
    }
}
