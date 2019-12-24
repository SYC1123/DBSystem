package com.example.dbsystem.Interface;

public interface ChangeInfoCallback<C> {
    void onSucceed(C response);

    void onFalied(C errStr);
}
