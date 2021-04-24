package com.rain.arouterdemo;

import com.rain.arouterdemo.arouter.annotation.Route;
import com.rain.arouterdemo.arouter.navigator.ActivityNavigator;

public interface AppNavigator {
    String _selectPage = "/select/contactFragment";

    @Route(path = _selectPage)
    ActivityNavigator<SelectInfo> toSelectContactPage();
}
