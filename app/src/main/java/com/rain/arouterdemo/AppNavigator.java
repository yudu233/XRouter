package com.rain.arouterdemo;

import android.os.Bundle;

import com.rain.arouterdemo.arouter.annotation.Extras;
import com.rain.arouterdemo.arouter.annotation.Route;
import com.rain.arouterdemo.arouter.navigator.ActivityNavigator;

public interface AppNavigator {
    String _selectPage = "/select/contactActivity";

    @Route(path = _selectPage)
    ActivityNavigator<SelectInfo> toSelectContactPage(@Extras Bundle ss);
}
