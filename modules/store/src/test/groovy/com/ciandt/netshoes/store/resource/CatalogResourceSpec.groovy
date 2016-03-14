package com.ciandt.netshoes.store.resource

import com.ciandt.netshoes.store.StoreApplication
import com.ciandt.netshoes.store.domain.Catalog
import com.ciandt.netshoes.store.resources.CatalogResource
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.ws.rs.core.Response
import java.time.LocalDate

/**
 * Created by erickpr on 11/03/16.
 */

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = [StoreApplication.class])
@WebIntegrationTest
class CatalogResourceSpec extends Specification {

    @Autowired
    private CatalogResource catalogResource;

    def "Dado que eu acesse a loja deve trazer o catalogo do dia corrente"() {
        setup:
        Response response = catalogResource.get()
        String json = new Gson().toJson(response.getEntity());
        Catalog catalog = new Gson().fromJson(json, Catalog.class)
        expect: "Catalogo não pode ser null e a data tem que ser igual a informada"
        assert catalog != null
        assert catalog.catalogDay == LocalDate.now();
    }


}
