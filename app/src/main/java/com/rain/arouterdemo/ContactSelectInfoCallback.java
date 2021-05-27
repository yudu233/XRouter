package com.rain.arouterdemo;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.rain.arouterdemo.SelectInfo;
import com.rain.arouterdemo.arouter.callback.RouteCallback;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:51 PM
 *  @VersonCode :       1.0
 *  @Descroption :      a callback
 */
public abstract class ContactSelectInfoCallback extends RouteCallback<SelectInfo> {
    @Override
    public SelectInfo parseData(int requestCode, int resultCode, @NonNull Intent data) {
        return (SelectInfo)data.getSerializableExtra("selectInfo");
    }
}
