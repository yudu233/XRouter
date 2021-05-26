package com.rain.arouterdemo.arouter.navigator;

import com.rain.arouterdemo.arouter.XRouter;
import com.rain.arouterdemo.arouter.annotation.Route;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

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

    private static boolean isNavigator(Class<?> returnType) {
        return returnType == ActivityNavigator.class
                || returnType == FragmentNavigator.class
                || returnType == ServiceNavigator.class
                || returnType == Navigator.class;
    }

    public Object invoke(Object[] args) {

        NavigatorBuilder builder = XRouter.getRouter().build(mRoute.path());
        Navigator navigator = builder
                .withRequestCode(mRoute.requestCode())
                .navigator();
        if (isNavigator(returnType)) {
            return navigator;
        }

        return navigator;
    }
}
