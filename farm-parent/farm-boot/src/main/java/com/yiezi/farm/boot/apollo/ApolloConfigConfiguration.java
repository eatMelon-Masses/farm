package com.yiezi.farm.boot.apollo;

import com.ctrip.framework.apollo.Apollo;
import com.yiezi.farm.boot.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * bean configuration for apollo.
 *
 * @author zane
 * @date 2021/2/8
 */
@ConditionalOnClass(Apollo.class)
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({ApolloConfigProperties.class})
public class ApolloConfigConfiguration {
}
