package com.rain.arouterdemo.arouter.navigator;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface ServiceNavigator {
    <T extends IProvider> T service();

}
