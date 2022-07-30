package com.yiezi.farm.boot.condition;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

import java.util.Objects;

/**
 * On Property Condition.
 *
 * @author zane
 * @date 2021/2/26
 */
public class OnPropertyCondition implements Condition {
    @Override
    public boolean matches(@NonNull final ConditionContext context, @NonNull final AnnotatedTypeMetadata metadata) {
        if (metadata.isAnnotated(ConditionalOnProperty.class.getName())) {
            final MergedAnnotation<ConditionalOnProperty> annotation =
                metadata.getAnnotations().get(ConditionalOnProperty.class);
            final String name = annotation.getString("name");
            final String havingValue = annotation.getString("havingValue");
            final String propertyValue = context.getEnvironment().getProperty(name);
            if (StringUtils.isNotEmpty(havingValue)) {
                return Objects.equals(havingValue, propertyValue);
            }
            return Boolean.TRUE.toString().equalsIgnoreCase(propertyValue);
        }
        return false;
    }
}
