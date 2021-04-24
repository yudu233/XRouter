package com.rain.arouterdemo.arouter.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public interface IActivityManagerService {
    String PATH = "/xrouter/service/activityManager";

    Context getContext();

    void addOnActivityResultListener(OnActivityResultListener listener);

    void onActivityResult(Activity context, int requestCode, int resultCode, Intent data);

    interface OnActivityResultListener{

        void onActivityResult(Activity context, int requestCode, int resultCode, Intent data);
    }

}
