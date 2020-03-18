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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Magpie extends SchemaImpl {

    private static final long serialVersionUID = 1384125645;

    /**
     * The reference instance of <code>magpie</code>
     */
    public static final Magpie MAGPIE = new Magpie();

    /**
     * The table <code>magpie.TEST_DUMMY</code>.
     */
    public final TestDummy TEST_DUMMY = com.magpie.jooq.tables.TestDummy.TEST_DUMMY;

    /**
     * The table <code>magpie.category</code>.
     */
    public final Category CATEGORY = com.magpie.jooq.tables.Category.CATEGORY;

    /**
     * The table <code>magpie.currency_info</code>.
     */
    public final CurrencyInfo CURRENCY_INFO = com.magpie.jooq.tables.CurrencyInfo.CURRENCY_INFO;

    /**
     * The table <code>magpie.items</code>.
     */
    public final Items ITEMS = com.magpie.jooq.tables.Items.ITEMS;

    /**
     * The table <code>magpie.location</code>.
     */
    public final Location LOCATION = com.magpie.jooq.tables.Location.LOCATION;

    /**
     * The table <code>magpie.user</code>.
     */
    public final User USER = com.magpie.jooq.tables.User.USER;

    /**
     * No further instances allowed
     */
    private Magpie() {
        super("magpie", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            TestDummy.TEST_DUMMY,
            Category.CATEGORY,
            CurrencyInfo.CURRENCY_INFO,
            Items.ITEMS,
            Location.LOCATION,
            User.USER);
    }
}
