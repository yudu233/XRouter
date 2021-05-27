package com.rain.arouterdemo.arouter.navigator;

import com.rain.arouterdemo.arouter.XRouter;
import com.rain.arouterdemo.arouter.annotation.Route;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:48 PM
 *  @VersonCode :       1.0
 *  @Descroption :      调用invoke方法的助手类
 */
public class NavigationMethod {

    private final Class<?> returnType;
    private final Annotation[][] parameterAnnotations;

    private Route mRoute;

    public NavigationMethod(Method method) {
        returnType = method.getReturnType();
        parameterAnnotations = method.getParameterAnnotations();
        Annotation[] methodAnnotations = method.getAnnotations();
        for (Annotation annotation :
                methodAnnotations) {
            if (annotation instanceof Route) {
                mRoute = (Route) annotation;
            }
        }
        if (mRoute == null) {
            throw new IllegalArgumentException("no Route annotation found");
        }

    }

    public Object invoke(Object[] args) {

        NavigatorBuilder builder = XRouter.getRouter().build(mRoute.path());
        Navigator navigator = builder
                .withRequestCode(mRoute.requestCode())
                .navigator();
        return navigator;
    }
}
