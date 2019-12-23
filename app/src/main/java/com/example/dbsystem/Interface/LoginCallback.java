package com.example.dbsystem.Interface;

public interface LoginCallback<L> {
    void onSucceed(L response);

    void onFalied(L errStr);

}
