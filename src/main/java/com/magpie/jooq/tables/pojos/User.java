/*
 * This file is generated by jOOQ.
 */
package com.magpie.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User implements Serializable {

    private static final long serialVersionUID = 1786404817;

    private Integer id;
    private String  name;
    private String  account;
    private String  countryCode;

    public User() {}

    public User(User value) {
        this.id = value.id;
        this.name = value.name;
        this.account = value.account;
        this.countryCode = value.countryCode;
    }

    public User(
        Integer id,
        String  name,
        String  account,
        String  countryCode
    ) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.countryCode = countryCode;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(account);
        sb.append(", ").append(countryCode);

        sb.append(")");
        return sb.toString();
    }
}
