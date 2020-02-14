package com.example.githubtestapp.usersList;

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

public class UsersListFragment extends Fragment {

    @Inject
    UsersListViewModel model;

    private UsersListComponent usersListComponent;
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
       usersListComponent = activityCallBack.getActivity().getAppComponent().createUsersComponent();
       usersListComponent.injectUsersFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        UsersListView usersListView = new UsersListView(inflater ,this , container , model);

        return usersListView.viewLayout;
    }

    @Override
    public void onDestroy() {
        DisposableManager.dispose();
        if(usersListComponent != null){
            usersListComponent = null;
        }
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
