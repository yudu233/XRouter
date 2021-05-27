package com.rain.arouterdemo.arouter.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.LruCache;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.arouterdemo.arouter.Constant;
import com.rain.arouterdemo.arouter.XRouter;
import com.rain.arouterdemo.arouter.callback.RouteCallback;
import com.rain.arouterdemo.arouter.navigator.NavigationMethod;
import com.rain.arouterdemo.arouter.navigator.NavigatorBuilder;
import com.rain.arouterdemo.arouter.navigator.Router;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:32 PM
 *  @VersonCode :       1.0
 *  @Descroption :      路由跳转服务的实现
 */
@Route(path = Router.PATH)
public class NavigatorService implements IProvider, Router, IActivityManagerService.OnActivityResultListener {

    private Map<Activity, RouteCallback> mRouteCallbackHolder;
    private LruCache<Class<?>, Object> mNavigatorCache;

    private IActivityManagerService mActivityManager;

    @Override
    public void init(Context context) {

    }

    @Override
    public IActivityManagerService getActivityManager() {
        if (mActivityManager == null) {
            Postcard postcard = ARouter.getInstance().build(Constant.PATH);
            NavigatorImpl navigator = new NavigatorImpl(postcard);
            mActivityManager = navigator.service();
        }
        return mActivityManager;
    }

    @Override
    public <T> T create(final Class<T> navigator) {
        if (!navigator.isInterface()) {
            throw new IllegalArgumentException("navigator declarations must be interfaces.");
        } else if (navigator.getInterfaces().length > 0) {
            throw new IllegalArgumentException("navigator interfaces must not extend other interfaces.");
        }
        LruCache<Class<?>, Object> navigators = getNavigatorCache();
        Object o = navigators.get(navigator);
        if (o == null) {
                o = Proxy.newProxyInstance(navigator.getClassLoader(), new Class[]{navigator}, new InvocationHandler() {
                    LruCache<Method, NavigationMethod> mNavigatorMethods;

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        if (mNavigatorMethods == null) {
                            mNavigatorMethods = new LruCache<>(5);
                        }
                        NavigationMethod navigationMethod = mNavigatorMethods.get(method);
                        if (navigationMethod == null) {
                            navigationMethod = new NavigationMethod(method);
                            mNavigatorMethods.put(method, navigationMethod);
                        }
                        return navigationMethod.invoke(args);
                    }
                });

            navigators.put(navigator, o);
        }
        return (T) o;
    }

    @Override
    public NavigatorBuilder build(String path) {
        return new NavigatorBuilder(path);
    }

    @Override
    public Context getContext() {
        return getActivityManager().getContext();
    }

    @Override
    public void startActivityForResult(Postcard postcard, int requestCode, RouteCallback callback) {
        Context context = getContext();
        XRouter.getRouter().getActivityManager().addOnActivityResultListener(NavigatorService.this);
        if (context instanceof Activity && requestCode > 0) {
            Activity activity = (Activity) context;
            if (callback != null) {
                getRouteCallbackHolder().put(activity, callback);
            }
            postcard.withInt(Constant.RequestCode, requestCode);
            postcard.navigation(activity, requestCode);
        } else {
            postcard.navigation(context);
        }
    }

    @Override
    public void onActivityResult(Activity context, int requestCode, int resultCode, Intent data) {
        if (context != null) {
            RouteCallback routeCallback = getRouteCallbackHolder().remove(context);
            if (routeCallback != null) {
                routeCallback.onResponse(requestCode, resultCode, data);
            }
        }
    }

    private LruCache<Class<?>, Object> getNavigatorCache() {
        if (mNavigatorCache == null) {
            mNavigatorCache = new LruCache<>(5);
        }
        return mNavigatorCache;
    }

    private Map<Activity, RouteCallback> getRouteCallbackHolder() {
        if (mRouteCallbackHolder == null) {
            mRouteCallbackHolder = new HashMap<>();
        }
        return mRouteCallbackHolder;
    }
}


