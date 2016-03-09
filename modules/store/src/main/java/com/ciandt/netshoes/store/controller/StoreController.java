package com.ciandt.netshoes.store.controller;

import com.ciandt.netshoes.store.domain.Category;
import com.ciandt.netshoes.store.domain.Product;
import com.ciandt.netshoes.store.service.StoreService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by erickpr on 09/03/16.
 */
@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @RequestMapping
    public ModelAndView list() {
        final Iterable<Product> products = storeService.findAll();
        return new ModelAndView("products/list", "products", products);
    }

    @RequestMapping("{id}")
    public ModelAndView view(@PathVariable("id") final String id) {
        final Product product = storeService.findById(id);
        return new ModelAndView("products/view", "product", product);
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute final Product product) {
        product.setCategory(new Category());
        return "products/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@Valid Product product, final BindingResult result,
        final RedirectAttributes redirect) {
        if (result.hasErrors()) {
            final ModelAndView mav = new ModelAndView("products/form");
            mav.addObject("formErrors", result.getAllErrors());
            mav.addObject("fieldErrors", getFieldErrors(result));
            return mav;
        }
        product = storeService.persist(product);
        redirect.addFlashAttribute("globalMessage", "Successfully created a new product");
        return new ModelAndView("redirect:/{product.id}", "product.id", product.getId());
    }

    private Map<String, ObjectError> getFieldErrors(final BindingResult result) {
        final Map<String, ObjectError> map = Maps.newHashMap();
        for (final FieldError error : result.getFieldErrors()) {
            map.put(error.getField(), error);
        }
        return map;
    }

    @RequestMapping("foo")
    public String foo() {
        throw new RuntimeException("Expected exception in controller");
    }
}
