package nhenneaux.test.swagger.ext;

import io.swagger.converter.ModelConverters;
import io.swagger.jaxrs.config.BeanConfig;

public class EnumModelAwareBeanConfig extends BeanConfig {
    public EnumModelAwareBeanConfig() {
        // remove and add; in case it is called multiple times.
        // should find a better way to register this.
        ModelConverters.getInstance().removeConverter(EnumAsModelAwareResolver.INSTANCE);
        ModelConverters.getInstance().addConverter(EnumAsModelAwareResolver.INSTANCE);
    }


}