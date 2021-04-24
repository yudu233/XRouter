package com.rain.arouterdemo.arouter.callback;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.rain.arouterdemo.SelectInfo;

public abstract class ContactSelectInfoCallback extends RouteCallback<SelectInfo> {
    @Override
    public SelectInfo parseData(int requestCode, int resultCode, @NonNull Intent data) {
        return (SelectInfo)data.getSerializableExtra("selectInfo");
    }
}
