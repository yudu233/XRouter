package com.rain.arouterdemo.arouter.navigator;

import  com.rain.arouterdemo.arouter.callback.RouteCallback;

public interface ActivityNavigator<T>{

    /**
     * startActivityForResult with callback
     * @param callback callback for processing result
     */
     void startActivityForResult(RouteCallback<T> callback);

}
