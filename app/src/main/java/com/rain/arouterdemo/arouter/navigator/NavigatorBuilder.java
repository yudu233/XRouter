package com.rain.arouterdemo.arouter.navigator;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.arouterdemo.arouter.Constant;
import com.rain.arouterdemo.arouter.service.NavigatorImpl;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:35 PM
 *  @VersonCode :       1.0
 *  @Descroption :      导航构造器
 */
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
        mPostcard.withInt(Constant.RequestCode, requestCode);
        return this;
    }

    public int getRequestCode(){
        return mPostcard.getExtras().getInt(Constant.RequestCode, -1);
    }

    public NavigatorBuilder withString(String key, String value){
        mPostcard.withString(key, value);
        return this;
    }

    public NavigatorBuilder withBoolean(String key, boolean value){
        mPostcard.withBoolean(key, value);
        return this;
    }

    public NavigatorBuilder withShort(String key, short value){
        mPostcard.withShort(key, value);
        return this;
    }

    public NavigatorBuilder withInt(String key, int value){
        mPostcard.withInt(key, value);
        return this;
    }
}
