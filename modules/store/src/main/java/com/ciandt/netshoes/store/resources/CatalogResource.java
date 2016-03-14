package com.ciandt.netshoes.store.resources;

import com.ciandt.netshoes.store.domain.Catalog;
import com.ciandt.netshoes.store.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

/**
 * Created by erickpr on 11/03/16.
 */
@Component
@Path("/catalog")
public class CatalogResource {

    @Autowired
    private CatalogService catalogService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        final Catalog catalog = catalogService.getCurrent(LocalDate.now());
        return Response.ok(catalog).build();
    }
}
