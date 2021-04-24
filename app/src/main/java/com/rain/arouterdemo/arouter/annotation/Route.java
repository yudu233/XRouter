package com.rain.arouterdemo.arouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Define the route in navigator interfaces
 * @author MondyXue <a href="mailto:mondyxue@gmail.com">E-Mail</a>
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {

    String path();

    int requestCode() default -1;

}
