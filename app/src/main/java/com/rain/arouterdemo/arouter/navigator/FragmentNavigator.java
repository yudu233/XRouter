package com.rain.arouterdemo.arouter.navigator;

import androidx.fragment.app.Fragment;

public interface FragmentNavigator {
    <T extends Fragment> T fragment();
}
