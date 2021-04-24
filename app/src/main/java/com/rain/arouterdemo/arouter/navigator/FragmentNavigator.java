package com.rain.arouterdemo.arouter.navigator;

import androidx.fragment.app.Fragment;

public interface FragmentNavigator {
    /** return the target fragment */
    <T extends Fragment> T fragment();
}
