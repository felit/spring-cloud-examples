package com.livedrof.springBoot.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OperateLog {
    String value() default "operate log";
}
