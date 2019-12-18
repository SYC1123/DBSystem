package com.example.dbsystem.Interface;


public interface RegisterCallback<R> {

    void onSucceed(R response);

    void onFalied(R errStr);


}
