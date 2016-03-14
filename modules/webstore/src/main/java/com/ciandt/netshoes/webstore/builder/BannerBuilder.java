package com.ciandt.netshoes.webstore.builder;

import com.ciandt.netshoes.webstore.domain.Banner;

/**
 * Created by erickpr on 14/03/16.
 */
public class BannerBuilder {
    private final Banner banner;

    private BannerBuilder() {
        banner = new Banner();
    }

    public static BannerBuilder aBanner() {
        return new BannerBuilder();
    }

    public BannerBuilder withId(final Long id) {
        this.banner.setId(id);
        return this;
    }

    public BannerBuilder withPath(final String path) {
        this.banner.setPath(path);
        return this;
    }

    public Banner build() {
        return banner;
    }
}
