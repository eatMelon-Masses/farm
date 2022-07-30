package com.yiezi.farm.boot.apollo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * Apollo Config Properties, only use for autocomplete.
 *
 * @author zane
 * @date 2021/2/9
 */
@ConfigurationProperties("apollo")
public class ApolloConfigProperties {
    /**
     * bootstrap config.
     */
    @NestedConfigurationProperty
    private final Bootstrap bootstrap = new Bootstrap();

    /**
     * meta server access key.
     */
    @NestedConfigurationProperty
    private final Accesskey accesskey = new Accesskey();

    /**
     * property config.
     */
    @NestedConfigurationProperty
    private final Property property = new Property();

    /**
     * app id
     */
    private String appId;

    /**
     * meta server url.
     */
    private String meta;

    /**
     * meta server cluster.
     */
    private String cluster;

    /**
     * config cache dir.
     */
    private String cacheDir;

    /**
     * auto update injected spring properties in runtime,default:true.
     */
    private boolean autoUpdateInjectedSpringProperties = true;

    public String getAppId() {
        return appId;
    }

    public void setAppId(final String appId) {
        this.appId = appId;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(final String meta) {
        this.meta = meta;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(final String cluster) {
        this.cluster = cluster;
    }

    public String getCacheDir() {
        return cacheDir;
    }

    public void setCacheDir(final String cacheDir) {
        this.cacheDir = cacheDir;
    }

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public Accesskey getAccesskey() {
        return accesskey;
    }

    public Property getProperty() {
        return property;
    }

    public boolean isAutoUpdateInjectedSpringProperties() {
        return autoUpdateInjectedSpringProperties;
    }

    public void setAutoUpdateInjectedSpringProperties(final boolean autoUpdateInjectedSpringProperties) {
        this.autoUpdateInjectedSpringProperties = autoUpdateInjectedSpringProperties;
    }

    /**
     * bootstrap wrapper.
     */
    public static class Bootstrap {
        /**
         * namespaces in bootstrap phase need inject.
         */
        private final Set<String> namespaces = new HashSet<>();

        /**
         * eager load config.
         */
        @NestedConfigurationProperty
        private final EagerLoad eagerLoad = new EagerLoad();

        /**
         * will inject 'application' namespace in bootstrap phase if enabled is true,default:true.
         */
        private boolean enabled = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }

        public Set<String> getNamespaces() {
            return namespaces;
        }

        public EagerLoad getEagerLoad() {
            return eagerLoad;
        }
    }

    /**
     * if need manage logger config, set enabled:true.
     */
    static class EagerLoad {
        /**
         * put apollo initialization before logging system initialization,default:false.
         */
        private boolean enabled = false;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }
    }

    /**
     * meta server access key.
     */
    public static class Accesskey {
        /**
         * key secret.
         */
        private String secret;

        public String getSecret() {
            return secret;
        }

        public void setSecret(final String secret) {
            this.secret = secret;
        }
    }

    /**
     * property order wrapper.
     */
    public static class Property {
        /**
         * property order.
         */
        private final Order order = new Order();

        public Order getOrder() {
            return order;
        }
    }

    /**
     * property order.
     */
    public static class Order {
        /**
         * keep property order,default: false.
         */
        private boolean enabled = false;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(final boolean enabled) {
            this.enabled = enabled;
        }
    }
}
