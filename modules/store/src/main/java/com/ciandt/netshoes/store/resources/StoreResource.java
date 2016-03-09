package com.ciandt.netshoes.store.resources;

import com.ciandt.netshoes.store.domain.Product;
import com.ciandt.netshoes.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by erickpr on 08/03/16.
 */

@Path("/store")
public class StoreResource {

    @Autowired
    private StoreService storeService;

    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") final String id) {
        final Product product = storeService.findById(id);
        return Response.ok(product).build();
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        final List<Product> products = storeService.findAll();
        return Response.ok(products).build();
    }

    @POST
    @Path("/product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Product product) {
        product = storeService.persist(product);
        return Response.ok(product).build();
    }

    @POST
    @Path("/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(List<Product> products) {
        products = storeService.persist(products);
        return Response.ok(products).build();
    }

    @DELETE
    @Path("/product/{id}")
    public void remove(final String id) {
        storeService.remove(id);
    }

}
