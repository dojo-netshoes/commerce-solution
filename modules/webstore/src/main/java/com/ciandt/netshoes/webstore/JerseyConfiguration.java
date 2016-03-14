package com.ciandt.netshoes.webstore;

import com.ciandt.netshoes.webstore.resources.CatalogResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by erickpr on 08/03/16.
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        registerResources();
    }

    private void registerResources() {
        register(CatalogResource.class);
    }
}
