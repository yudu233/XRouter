package com.rain.arouterdemo.arouter.impl;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.rain.arouterdemo.arouter.RouteExtras;
import com.rain.arouterdemo.arouter.XRouter;
import com.rain.arouterdemo.arouter.callback.RouteCallback;
import com.rain.arouterdemo.arouter.navigator.Navigator;

public class NavigatorImpl implements Navigator {
    private Postcard mPostcard;

    public NavigatorImpl(Postcard postcard){
        mPostcard = postcard;
    }


    @Override
    public <T extends Fragment> T fragment() {
        return (T) mPostcard.navigation();
    }


    @Override
    public void startActivityForResult(RouteCallback callback) {
        int requestCode = -1;
        Bundle extras = mPostcard.getExtras();
        if (extras != null) {
            // check the request code
            requestCode = extras.getInt(RouteExtras.RequestCode, requestCode);
            if (requestCode == -1) {
                requestCode = 200;
            }
        }
        XRouter.getRouter().startActivityForResult(mPostcard, requestCode, callback);
    }

    @Override
    public <T extends IProvider> T service() {
        return (T) mPostcard.navigation();
    }
}
