package de.evosec.wro4j.spi;

import java.util.HashMap;
import java.util.Map;

import ro.isdc.wro.model.resource.support.naming.NamingStrategy;
import ro.isdc.wro.util.provider.ConfigurableProviderSupport;
import de.evosec.wro4j.CacheHashEncoderNamingStrategy;

public class DefaultConfigurableProvider extends ConfigurableProviderSupport {
    @Override
    public Map<String, NamingStrategy> provideNamingStrategies() {
        final Map<String, NamingStrategy> map = new HashMap<String, NamingStrategy>();
        map.put(CacheHashEncoderNamingStrategy.ALIAS, new CacheHashEncoderNamingStrategy());
        return map;
    }
}
