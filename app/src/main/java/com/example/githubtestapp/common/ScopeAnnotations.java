package com.example.githubtestapp.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

public class ScopeAnnotations {
    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerActivity {
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerUsersFragment {
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerUserInfoFragment {
    }
}
