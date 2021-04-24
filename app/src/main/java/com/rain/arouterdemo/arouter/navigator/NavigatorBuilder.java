package com.rain.arouterdemo.arouter.navigator;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.arouterdemo.arouter.RouteExtras;
import com.rain.arouterdemo.arouter.impl.NavigatorImpl;

public class NavigatorBuilder {
    private Postcard mPostcard;
    public NavigatorBuilder(String path){
        mPostcard = ARouter.getInstance().build(path);
    }
    NavigatorBuilder(Postcard postcard){
        mPostcard = postcard;
    }

    public Navigator navigator(){
        return new NavigatorImpl(mPostcard);
    }

    public Postcard postcard(){
        return mPostcard;
    }

    public NavigatorBuilder withRequestCode(int requestCode){
        mPostcard.withInt(RouteExtras.RequestCode, requestCode);
        return this;
    }

    public int getRequestCode(){
        return mPostcard.getExtras().getInt(RouteExtras.RequestCode, -1);
    }
}
