package com.yiezi.farm.boot.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Conditional On Property.
 *
 * @author zane
 * @date 2021/2/26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional({OnPropertyCondition.class})
public @interface ConditionalOnProperty {
    /**
     * @return property name
     */
    @AliasFor("name")
    String value() default "";

    /**
     * @return property name
     */
    String name() default "";

    /**
     * @return property value specified property should have,
     */
    String havingValue() default "";
}
