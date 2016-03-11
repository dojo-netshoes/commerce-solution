package com.ciandt.netshoes.store.service.impl;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erickpr on 01/03/16.
 */
public class OtherUserServiceImpl {

    private List<String> users = new ArrayList<>();

    public OtherUserServiceImpl(final List users) {
        this.users = users;
    }

    public OtherUserServiceImpl() {
    }

    public List getUsers() {
        return users;
    }

    public void setUsers(final List users) {
        this.users = users;
    }


    public Integer count() {
        if (users == null) {
            users = Lists.newArrayList();
        }
        return users.size();
    }
}
