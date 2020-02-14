package com.example.githubtestapp.userInfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.githubtestapp.ActivityCallBack;
import com.example.githubtestapp.MainActivity;
import com.example.githubtestapp.common.DisposableManager;

import javax.inject.Inject;

public class UserInfoFragment extends Fragment {

    @Inject
    UserInfoViewModel model;
    private UserInfoComponent userInfoComponent;
    private ActivityCallBack activityCallBack;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity instanceof ActivityCallBack)
            activityCallBack = (ActivityCallBack)activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userInfoComponent = activityCallBack.getActivity().getAppComponent().createUserInfoComponent();
        userInfoComponent.injectUserInfoFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if(bundle != null) {
            String login = bundle.getString("USER_LOGIN");
            String imageUrl = bundle.getString("USER_IMAGE_URL");
            model.initUserInfoLiveData(login, imageUrl);
        }

        UserInfoView userInfoView = new UserInfoView(inflater, this, container, model);

        return userInfoView.viewLayout;
    }

    @Override
    public void onDestroy() {
        DisposableManager.dispose();

        if(userInfoComponent != null){
            userInfoComponent = null;
        }

        super.onDestroy();
    }
}
