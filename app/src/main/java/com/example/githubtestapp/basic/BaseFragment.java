package com.example.githubtestapp.basic;

import androidx.fragment.app.Fragment;

import com.example.githubtestapp.MainActivity;

public abstract class BaseFragment extends Fragment {

    public MainActivity getMainActivity(){
        return ((MainActivity) getActivity());
    }

}
