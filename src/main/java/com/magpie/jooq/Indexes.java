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

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>magpie</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index TEST_DUMMY_PRIMARY = Indexes0.TEST_DUMMY_PRIMARY;
    public static final Index CATEGORY_PRIMARY = Indexes0.CATEGORY_PRIMARY;
    public static final Index CURRENCY_INFO_PRIMARY = Indexes0.CURRENCY_INFO_PRIMARY;
    public static final Index ITEMS_CATEGORY_ON_ITEM_FK_IDX = Indexes0.ITEMS_CATEGORY_ON_ITEM_FK_IDX;
    public static final Index ITEMS_LOCATION_ON_ITEM_FK_IDX = Indexes0.ITEMS_LOCATION_ON_ITEM_FK_IDX;
    public static final Index ITEMS_PRIMARY = Indexes0.ITEMS_PRIMARY;
    public static final Index LOCATION_PRIMARY = Indexes0.LOCATION_PRIMARY;
    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index TEST_DUMMY_PRIMARY = Internal.createIndex("PRIMARY", TestDummy.TEST_DUMMY, new OrderField[] { TestDummy.TEST_DUMMY.ID }, true);
        public static Index CATEGORY_PRIMARY = Internal.createIndex("PRIMARY", Category.CATEGORY, new OrderField[] { Category.CATEGORY.ID }, true);
        public static Index CURRENCY_INFO_PRIMARY = Internal.createIndex("PRIMARY", CurrencyInfo.CURRENCY_INFO, new OrderField[] { CurrencyInfo.CURRENCY_INFO.ID }, true);
        public static Index ITEMS_CATEGORY_ON_ITEM_FK_IDX = Internal.createIndex("category_on_item_fk_idx", Items.ITEMS, new OrderField[] { Items.ITEMS.CAT_ID }, false);
        public static Index ITEMS_LOCATION_ON_ITEM_FK_IDX = Internal.createIndex("location_on_item_fk_idx", Items.ITEMS, new OrderField[] { Items.ITEMS.LOCATION_ID }, false);
        public static Index ITEMS_PRIMARY = Internal.createIndex("PRIMARY", Items.ITEMS, new OrderField[] { Items.ITEMS.ID }, true);
        public static Index LOCATION_PRIMARY = Internal.createIndex("PRIMARY", Location.LOCATION, new OrderField[] { Location.LOCATION.ID }, true);
        public static Index USER_PRIMARY = Internal.createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.ID }, true);
    }
}
