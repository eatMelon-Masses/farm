package com.yiezi.farm.boot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * On Class Condition.
 *
 * @author zane
 * @date 2021/2/18
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OnClassCondition implements Condition {
    @Override
    public boolean matches(@NonNull final ConditionContext context, @NonNull final AnnotatedTypeMetadata metadata) {
        final MergedAnnotation<ConditionalOnClass> annotation = metadata.getAnnotations().get(ConditionalOnClass.class);
        if (annotation.isPresent()) {
            String className = annotation.getString("value");
            className = Objects.equals(Void.class.getName(), className) ? annotation.getString("name") : className;
            Assert.hasText(className, "condition class name must not be empty.");
            try {
                final ClassLoader classLoader = Objects.requireNonNull(context.getClassLoader());
                return Objects.nonNull(classLoader.loadClass(className));
            } catch (ClassNotFoundException ignored) {
            }
        }
        return false;
    }
}
