package com.ciandt.netshoes.store.domain;

/**
 * Created by erickpr on 01/03/16.
 */
public class Show {

    String name;
    int startTime;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(final int startTime) {
        this.startTime = startTime;
    }
}
