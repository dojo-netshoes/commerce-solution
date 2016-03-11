package com.ciandt.netshoes.store.service.impl;

import com.ciandt.netshoes.store.domain.Show;
import com.ciandt.netshoes.store.service.AgeService;

/**
 * Created by erickpr on 01/03/16.
 */
public class ClassUnderTest {

    AgeService ageService;

    public boolean listing(final Show show) {
        final int hour = ageService.allowedMaxtime(show);
        return show.getStartTime() <= hour;
    }

    public AgeService getAgeService() {
        return ageService;
    }

    public void setAgeService(final AgeService ageService) {
        this.ageService = ageService;
    }
}
