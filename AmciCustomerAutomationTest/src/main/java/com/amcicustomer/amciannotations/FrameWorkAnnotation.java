package com.amcicustomer.amciannotations;

import com.amcicustomer.enums.CategoryType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameWorkAnnotation {

    String[] author();

    CategoryType[] category();

    public String[] TESTID() default {};

}
