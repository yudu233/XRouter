package com.rain.arouterdemo.arouter.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:38 PM
 *  @VersonCode :       1.0
 *  @Descroption :
 */
public interface IActivityManagerService {

    Context getContext();

    void addOnActivityResultListener(OnActivityResultListener listener);

    void onActivityResult(Activity context, int requestCode, int resultCode, Intent data);

    interface OnActivityResultListener{

        void onActivityResult(Activity context, int requestCode, int resultCode, Intent data);
    }

}
