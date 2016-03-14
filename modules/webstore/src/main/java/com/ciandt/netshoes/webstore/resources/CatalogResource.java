package com.ciandt.netshoes.webstore.resources;

import com.ciandt.netshoes.webstore.domain.Catalog;
import com.ciandt.netshoes.webstore.usecase.CatalogCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by erickpr on 14/03/16.
 */
@Path("/catalog")
@Component
public class CatalogResource {

    @Autowired
    private CatalogCommand catalogCommand;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        final Catalog catalog = catalogCommand.execute();
        return Response.ok(catalog).build();
    }

}
