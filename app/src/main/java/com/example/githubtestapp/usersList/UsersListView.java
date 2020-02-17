package com.example.githubtestapp.usersList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtestapp.R;
import com.example.githubtestapp.basic.BaseView;
import com.example.githubtestapp.databinding.UserListBinding;
import com.example.githubtestapp.usersList.recyclerView.UsersListRecyclerAdapter;



public class UsersListView extends BaseView {

    private RecyclerView recyclerView;
    private Context context;
    private EditText etSince;
    private ImageView btnRefresh;

    public UsersListView(@NonNull LayoutInflater inflater, @NonNull LifecycleOwner lifecycleOwner,
                         @Nullable ViewGroup container, @NonNull UsersListViewModel model) {

        UserListBinding mDataBinding = DataBindingUtil.inflate(inflater, R.layout.user_list, container, false);
        mDataBinding.setLifecycleOwner(lifecycleOwner);
        mDataBinding.executePendingBindings();
        mDataBinding.setViewModel(model);
        viewLayout = mDataBinding.getRoot();
        context = viewLayout.getContext();
        initIds();

        btnRefresh.setOnClickListener((v)->{
            String sinceStr = etSince.getText().toString();
            int since = Integer.parseInt(sinceStr);
            model.refreshUserList(since);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        UsersListRecyclerAdapter adapter = new UsersListRecyclerAdapter((userLogin , imageUrl)-> model.navigateToUserInfo(userLogin , imageUrl));
        recyclerView.setAdapter(adapter);

        model.userListLiveData.observe(lifecycleOwner , userList -> {
            adapter.setUserList(userList);
        });
    }

    private void initIds(){
        etSince = viewLayout.findViewById(R.id.since);
        btnRefresh = viewLayout.findViewById(R.id.refresh);
        recyclerView = viewLayout.findViewById(R.id.users_recycler);
    }




}
