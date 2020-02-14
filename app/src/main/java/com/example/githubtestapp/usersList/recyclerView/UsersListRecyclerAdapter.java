package com.example.githubtestapp.usersList.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtestapp.R;
import com.example.githubtestapp.remote.pojo.UserPojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class UsersListRecyclerAdapter extends RecyclerView.Adapter<UsersListRecyclerAdapter.ViewHolder> {


    private OnUserItemClick onUserItemClicked;
    private List<UserPojo> usersList = new ArrayList<>();

    public UsersListRecyclerAdapter(OnUserItemClick onUserItemClicked) {
        this.onUserItemClicked = onUserItemClicked;
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

//    public void loadImage(String imageUrl , CircleImageView imageView){
//       Disposable disposable = Observable.just(imageUrl)
//                .subscribeOn(Schedulers.io())
//                .flatMap((url) -> Observable.just(Picasso.get().load(url)))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe((image)->{
//                    image.into(imageView);
//                });
//        DisposableManager.add(disposable);
//    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserPojo currentUser = usersList.get(position);

        Picasso.get()
                .load(currentUser.getAvatarUrl())
                .into(holder.userImage);

       // loadImage(currentUser.getAvatarUrl() , holder.userImage);
        holder.userLogin.setText(currentUser.getLogin());
        holder.userItemParent.setOnClickListener((v)->{
            onUserItemClicked.onClick(currentUser.getLogin() , currentUser.getAvatarUrl());
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void setUserList(@Nullable List<UserPojo> pojos) {
        if (pojos == null) {
            return;
        }
        usersList.clear();
        usersList.addAll(pojos);
        notifyDataSetChanged();

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView userImage;
        ConstraintLayout userItemParent;
        TextView userLogin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userItemParent = itemView.findViewById(R.id.user_item_parent);
            userImage = itemView.findViewById(R.id.user_image);
            userLogin = itemView.findViewById(R.id.user_login);

        }

    }
}
