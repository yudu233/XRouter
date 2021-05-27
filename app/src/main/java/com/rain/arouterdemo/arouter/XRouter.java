package com.rain.arouterdemo.arouter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.arouterdemo.arouter.navigator.Router;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:36 PM
 *  @VersonCode :       1.0
 *  @Descroption :
 */
public class XRouter {

    private static Router router;

    /**
     * 获取ARouter实例
     * @return
     */
    public static Router getRouter(){
        if(router == null){
            router = (Router) ARouter.getInstance().build(Router.PATH).navigation();
        }
        return router;
    }
}

