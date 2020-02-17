package com.example.githubtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.githubtestapp.modules.NavModule;

public class MainActivity extends AppCompatActivity {

   static public AppComponent appComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAppComponent();
        setContentView(R.layout.navigation_container_fragment);
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    public void initAppComponent(){
        appComponent = DaggerAppComponent.builder()
                .navModule(new NavModule(this))
                .build();
    }
}
