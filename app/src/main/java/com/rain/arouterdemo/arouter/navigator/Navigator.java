package com.rain.arouterdemo.arouter.navigator;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.rain.arouterdemo.arouter.callback.RouteCallback;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:41 PM
 *  @VersonCode :       1.0
 *  @Descroption :      Navigator
 */
public interface Navigator<T>{

    <T extends Fragment> T fragment();

    <T extends IProvider> T service();

    void startActivityForResult(RouteCallback<T> callback);

}
