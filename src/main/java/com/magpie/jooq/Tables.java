/*
 * This file is generated by jOOQ.
 */
package com.magpie.jooq;


import com.magpie.jooq.tables.Category;
import com.magpie.jooq.tables.CurrencyInfo;
import com.magpie.jooq.tables.Items;
import com.magpie.jooq.tables.Location;
import com.magpie.jooq.tables.TestDummy;
import com.magpie.jooq.tables.User;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in magpie
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>magpie.TEST_DUMMY</code>.
     */
    public static final TestDummy TEST_DUMMY = TestDummy.TEST_DUMMY;

    /**
     * The table <code>magpie.category</code>.
     */
    public static final Category CATEGORY = Category.CATEGORY;

    /**
     * The table <code>magpie.currency_info</code>.
     */
    public static final CurrencyInfo CURRENCY_INFO = CurrencyInfo.CURRENCY_INFO;

    /**
     * The table <code>magpie.items</code>.
     */
    public static final Items ITEMS = Items.ITEMS;

    /**
     * The table <code>magpie.location</code>.
     */
    public static final Location LOCATION = Location.LOCATION;

    /**
     * The table <code>magpie.user</code>.
     */
    public static final User USER = User.USER;
}
