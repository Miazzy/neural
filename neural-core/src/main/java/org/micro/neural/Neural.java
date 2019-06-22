package org.micro.neural;

import org.micro.neural.config.GlobalConfig;
import org.micro.neural.config.GlobalConfig.*;
import org.micro.neural.config.RuleConfig;

import java.io.Serializable;
import java.util.Map;

/**
 * Neural
 *
 * @author lry
 */
public interface Neural<C extends RuleConfig, G extends GlobalConfig> extends Serializable {

    /**
     * The get global config
     *
     * @return {@link G}
     */
    G getGlobalConfig();

    /**
     * The add degrade
     *
     * @param config {@link C}
     */
    void addConfig(C config);

    /**
     * The notify of changed config
     *
     * @param category {@link Category}
     * @param identity the config identity, format: [application]:[group]:[resource]
     * @param data     the config data, format: serialize config data
     */
    void notify(Category category, String identity, String data);

    /**
     * The collect of get and reset statistics data
     *
     * @return statistics data
     */
    Map<String, Long> collect();

    /**
     * The get statistics data
     *
     * @return statistics data
     */
    Map<String, Long> statistics();

    /**
     * The process of wrapper original call
     *
     * @param identity     {@link org.micro.neural.config.RuleConfig}
     * @param originalCall {@link OriginalCall}
     * @return invoke return object
     * @throws Throwable throw exception
     */
    Object doWrapperCall(String identity, OriginalCall originalCall) throws Throwable;

    /**
     * The destroy store config
     */
    void destroy();

}