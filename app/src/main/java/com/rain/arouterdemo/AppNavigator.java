package com.rain.arouterdemo;

import android.os.Bundle;

import com.rain.arouterdemo.arouter.annotation.Extras;
import com.rain.arouterdemo.arouter.annotation.Route;
import com.rain.arouterdemo.arouter.navigator.Navigator;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:36 PM
 *  @VersonCode :       1.0
 *  @Descroption :
 */
public interface AppNavigator {
    String _selectPage = "/select/contactActivity";

    @Route(path = _selectPage)
    Navigator<SelectInfo> toSelectContactPage(@Extras Bundle ss);
}
