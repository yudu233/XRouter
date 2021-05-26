package com.rain.arouterdemo.arouter.navigator;

import  com.rain.arouterdemo.arouter.callback.RouteCallback;

public interface ActivityNavigator<T>{

     void startActivityForResult(RouteCallback<T> callback);

}
