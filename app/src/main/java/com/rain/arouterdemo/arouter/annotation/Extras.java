package com.rain.arouterdemo.arouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @AuthorName :       Rain
 * @Org :              https://www.yudu233.com
 * @CreateDate :       5/26/21 10:49 AM
 * @VersonCode :       1.0
 * @Descroption :      方法参数注解
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Extras {
}
