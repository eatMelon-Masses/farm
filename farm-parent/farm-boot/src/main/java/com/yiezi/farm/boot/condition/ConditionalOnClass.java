package com.yiezi.farm.boot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * class condition.
 *
 * @author zane
 * @date 2021/2/18
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnClassCondition.class)
public @interface ConditionalOnClass {
    /**
     * @return class
     */
    Class<?> value() default Void.class;

    /**
     * @return class name
     */
    String name() default "";
}
