package com.example.githubtestapp.userInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtestapp.R;
import com.example.githubtestapp.remote.pojo.UserReposPojo;


import java.util.ArrayList;
import java.util.List;

public class UserReposRecyclerAdapter extends RecyclerView.Adapter<UserReposRecyclerAdapter.ViewHolder> {

    private List<UserReposPojo> userRepos = new ArrayList<>();

    @Override
    public int getItemCount() {
        return userRepos.size();
    }

    @Override
    public void onBindViewHolder(@NonNull UserReposRecyclerAdapter.ViewHolder holder, int position) {
        UserReposPojo currentUser = userRepos.get(position);
        holder.title.setText(currentUser.getName());
        holder.lang.setText(currentUser.getLanguage());
    }

    @NonNull
    @Override
    public UserReposRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_repo_item, parent, false);
        return new UserReposRecyclerAdapter.ViewHolder(view);
    }

    public void setUserRepos(@Nullable List<UserReposPojo> pojos) {
        if (pojos == null) {
            return;
        }
        userRepos.clear();
        userRepos.addAll(pojos);
        notifyDataSetChanged();

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView lang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.repo_title);
            lang = itemView.findViewById(R.id.repo_lang);
        }

    }
}
