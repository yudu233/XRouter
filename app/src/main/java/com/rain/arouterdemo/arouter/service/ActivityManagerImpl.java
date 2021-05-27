package com.rain.arouterdemo.arouter.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.blankj.utilcode.util.ActivityUtils;
import com.rain.arouterdemo.arouter.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:37 PM
 *  @VersonCode :       1.0
 *  @Descroption :
 */
@Route(path = Constant.PATH)
public class ActivityManagerImpl implements IProvider, IActivityManagerService {

    private Context mContext;

    private List<OnActivityResultListener> mOnActivityResultListeners;


    @Override
    public void init(Context context) {
        mContext = context;
    }

    @Override
    public Context getContext() {
        if (ActivityUtils.getTopActivity() == null)
        return mContext;
        else return ActivityUtils.getTopActivity();
    }

    @Override
    public void addOnActivityResultListener(OnActivityResultListener listener) {
        if(mOnActivityResultListeners == null){
            mOnActivityResultListeners = new ArrayList<>();
        }
        if(!mOnActivityResultListeners.contains(listener)){
            mOnActivityResultListeners.add(listener);
        }
    }

    @Override
    public void onActivityResult(Activity context, int requestCode, int resultCode, Intent data) {
        if(mOnActivityResultListeners != null && !mOnActivityResultListeners.isEmpty()){
            for(OnActivityResultListener listener : mOnActivityResultListeners){
                listener.onActivityResult(context, requestCode, resultCode, data);
            }
        }
    }
}
