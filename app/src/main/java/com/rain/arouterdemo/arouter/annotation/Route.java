package com.rain.arouterdemo.arouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 10:38 AM
 *  @VersonCode :       1.0
 *  @Descroption :      方法注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {

    /**
     * 跳转路径
     * @return
     */
    String path();

    /**
     * 请求码
     * @return
     */
    int requestCode() default -1;

}
