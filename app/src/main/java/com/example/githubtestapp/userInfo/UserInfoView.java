package com.example.githubtestapp.userInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtestapp.R;
import com.example.githubtestapp.basic.BaseView;
import com.example.githubtestapp.databinding.UserInfoBinding;

public class UserInfoView extends BaseView {

    private Context context;
    private RecyclerView recyclerView;

    public UserInfoView(@NonNull LayoutInflater inflater, @NonNull LifecycleOwner lifecycleOwner,
                     @Nullable ViewGroup container, @NonNull UserInfoViewModel model) {

        UserInfoBinding mDataBinding = DataBindingUtil.inflate(inflater, R.layout.user_info, container, false);
        mDataBinding.setLifecycleOwner(lifecycleOwner);
        mDataBinding.executePendingBindings();
        mDataBinding.setViewModel(model);
        viewLayout = mDataBinding.getRoot();
        context = viewLayout.getContext();

        recyclerView = viewLayout.findViewById(R.id.repo_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        UserReposRecyclerAdapter adapter = new UserReposRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        model.userInfoLiveData.observe(lifecycleOwner , userInfo -> {
            adapter.setUserRepos(userInfo.getUserReposPojoList());
        });



    }
}
