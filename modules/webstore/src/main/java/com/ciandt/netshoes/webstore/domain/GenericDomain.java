package com.ciandt.netshoes.webstore.domain;

import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by erickpr on 08/03/16.
 */
public abstract class GenericDomain implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5521341141878010912L;
    private static final StandardToStringStyle stringStyle = new StandardToStringStyle();

    static {
        stringStyle.setUseClassName(false);
        stringStyle.setUseIdentityHashCode(false);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, stringStyle);
    }

}
