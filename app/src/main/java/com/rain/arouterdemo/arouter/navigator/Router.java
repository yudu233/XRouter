package com.rain.arouterdemo.arouter.navigator;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.rain.arouterdemo.arouter.callback.RouteCallback;
import com.rain.arouterdemo.arouter.service.IActivityManagerService;

public interface Router {
    String PATH = "/xrouter/navigator";

    <T> T create(Class<T> navigator);
    NavigatorBuilder build(String path);
    Context getContext();


    IActivityManagerService getActivityManager();

    void startActivityForResult(Postcard mPostcard, int requestCode, RouteCallback callback);
}
