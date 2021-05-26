package com.rain.arouterdemo.arouter;

import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.launcher.ARouter;
import  com.rain.arouterdemo.arouter.navigator.Router;

public class XRouter {
    private static Router sRouter;

    /**
     * 获取ARouter实例
     * @return
     */
    public static Router getRouter(){
        if(sRouter == null){
            sRouter = (Router) ARouter.getInstance().build(Router.PATH).navigation();
        }
        return sRouter;
    }
}

