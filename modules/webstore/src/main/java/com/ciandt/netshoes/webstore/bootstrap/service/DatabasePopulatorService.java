package com.ciandt.netshoes.webstore.bootstrap.service;

import com.ciandt.netshoes.webstore.builder.CatalogBuilder;
import com.ciandt.netshoes.webstore.builder.CategoryBuilder;
import com.ciandt.netshoes.webstore.builder.ProductBuilder;
import com.ciandt.netshoes.webstore.dao.CatalogDao;
import com.ciandt.netshoes.webstore.domain.Catalog;
import com.ciandt.netshoes.webstore.domain.Category;
import com.ciandt.netshoes.webstore.domain.Product;
import com.ciandt.netshoes.webstore.repository.CategoryRepository;
import com.ciandt.netshoes.webstore.repository.ProductRepository;
import com.ciandt.netshoes.webstore.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by erickpr on 11/03/16.
 */
@Service
public class DatabasePopulatorService {

    @Autowired
    private CatalogDao catalogDao;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public void execute() {
        Category futebol = CategoryBuilder.aCategory().withName("Futebol").build();

        futebol = categoryRepository.persist(futebol);

        Category bolas = CategoryBuilder.aCategory().withName("Bolas").withParent(futebol).build();

        bolas = categoryRepository.persist(bolas);

        Product bolaNike =
            ProductBuilder.aProduct().withCategory(bolas).withName("BOLA NIKE TEAM TRAINING CAMPO")
                .withDescription(
                    "A Bola Nike Team Training Campo entra em jogo e vai fazer a tabelinha perfeita com você. O equipamento é produzido em câmara de Borracha, e é altamente resistente para maior precisão durante os jogos.")
                .withPrice(new BigDecimal(44.90)).withStock(BigDecimal.TEN).withInstallments(1)
                .withPathImage("img/004-1911-042_zoom1.jpg").build();

        bolaNike = productRepository.persist(bolaNike);

        Category running = CategoryBuilder.aCategory().withName("Running").build();

        running = categoryRepository.persist(running);

        Category tenis = CategoryBuilder.aCategory().withName("Tenis").withParent(running).build();

        tenis = categoryRepository.persist(tenis);

        Product tenisEverlast =
            ProductBuilder.aProduct().withCategory(tenis).withName("TÊNIS EVERLAST RUNNER")
                .withDescription(
                    "O Tênis Everlast Runner é um calçado leve e confortável para suas corridas e treinos. Possui tecnologia Flexlight que oferece leveza, conforto e absorção de impactos para seus pés.")
                .withPrice(new BigDecimal(99.90)).withStock(BigDecimal.TEN).withInstallments(3)
                .withPathImage("img/D18-0207-204_zoom1.jpg").build();

        tenisEverlast = productRepository.persist(tenisEverlast);

        Product tenisAsics =
            ProductBuilder.aProduct().withCategory(tenis).withName("TÊNIS ASICS PATRIOT 7")
                .withDescription(
                    "Com um design moderno, o Tênis Asics Patriot 7 traz a combinação perfeita de estilo e versatilidade. O solado conta com tecnologia AHAR, que aumenta a durabilidade e reduz o peso do tênis")
                .withPrice(new BigDecimal(149.90)).withStock(BigDecimal.TEN).withInstallments(5)
                .withPathImage("img/017-9526-382_zoom1.jpg").build();

        tenisAsics = productRepository.persist(tenisAsics);

        final LocalDate localDate = LocalDate.now();
        Catalog catalog =
            CatalogBuilder.aCatalog().withCatalogDay(DateTools.localDateToDate(localDate))
                .withBanner("img/full4_gen_160311_ffffff_1366.jpg")
                .withBanner("img/full2_gen_160310_ffffff_1366.jpg")
                .withBanner("img/full4_gen_160311_ffffff_1366.jpg")
                .withBanner("img/full1_con_160301_ffffff_1366.jpg").withProduct(bolaNike)
                .withProduct(tenisAsics).withProduct(tenisEverlast).build();
        catalog = catalogDao.save(catalog);

    }
}
