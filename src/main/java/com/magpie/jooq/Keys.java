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
import com.magpie.jooq.tables.records.CategoryRecord;
import com.magpie.jooq.tables.records.CurrencyInfoRecord;
import com.magpie.jooq.tables.records.ItemsRecord;
import com.magpie.jooq.tables.records.LocationRecord;
import com.magpie.jooq.tables.records.TestDummyRecord;
import com.magpie.jooq.tables.records.UserRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>magpie</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<TestDummyRecord, Integer> IDENTITY_TEST_DUMMY = Identities0.IDENTITY_TEST_DUMMY;
    public static final Identity<CategoryRecord, Integer> IDENTITY_CATEGORY = Identities0.IDENTITY_CATEGORY;
    public static final Identity<CurrencyInfoRecord, Integer> IDENTITY_CURRENCY_INFO = Identities0.IDENTITY_CURRENCY_INFO;
    public static final Identity<ItemsRecord, Integer> IDENTITY_ITEMS = Identities0.IDENTITY_ITEMS;
    public static final Identity<LocationRecord, Integer> IDENTITY_LOCATION = Identities0.IDENTITY_LOCATION;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TestDummyRecord> KEY_TEST_DUMMY_PRIMARY = UniqueKeys0.KEY_TEST_DUMMY_PRIMARY;
    public static final UniqueKey<CategoryRecord> KEY_CATEGORY_PRIMARY = UniqueKeys0.KEY_CATEGORY_PRIMARY;
    public static final UniqueKey<CurrencyInfoRecord> KEY_CURRENCY_INFO_PRIMARY = UniqueKeys0.KEY_CURRENCY_INFO_PRIMARY;
    public static final UniqueKey<ItemsRecord> KEY_ITEMS_PRIMARY = UniqueKeys0.KEY_ITEMS_PRIMARY;
    public static final UniqueKey<LocationRecord> KEY_LOCATION_PRIMARY = UniqueKeys0.KEY_LOCATION_PRIMARY;
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = UniqueKeys0.KEY_USER_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ItemsRecord, CategoryRecord> CATEGORY_ON_ITEM_FK = ForeignKeys0.CATEGORY_ON_ITEM_FK;
    public static final ForeignKey<ItemsRecord, LocationRecord> LOCATION_ON_ITEM_FK_IDX = ForeignKeys0.LOCATION_ON_ITEM_FK_IDX;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<TestDummyRecord, Integer> IDENTITY_TEST_DUMMY = Internal.createIdentity(TestDummy.TEST_DUMMY, TestDummy.TEST_DUMMY.ID);
        public static Identity<CategoryRecord, Integer> IDENTITY_CATEGORY = Internal.createIdentity(Category.CATEGORY, Category.CATEGORY.ID);
        public static Identity<CurrencyInfoRecord, Integer> IDENTITY_CURRENCY_INFO = Internal.createIdentity(CurrencyInfo.CURRENCY_INFO, CurrencyInfo.CURRENCY_INFO.ID);
        public static Identity<ItemsRecord, Integer> IDENTITY_ITEMS = Internal.createIdentity(Items.ITEMS, Items.ITEMS.ID);
        public static Identity<LocationRecord, Integer> IDENTITY_LOCATION = Internal.createIdentity(Location.LOCATION, Location.LOCATION.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<TestDummyRecord> KEY_TEST_DUMMY_PRIMARY = Internal.createUniqueKey(TestDummy.TEST_DUMMY, "KEY_TEST_DUMMY_PRIMARY", TestDummy.TEST_DUMMY.ID);
        public static final UniqueKey<CategoryRecord> KEY_CATEGORY_PRIMARY = Internal.createUniqueKey(Category.CATEGORY, "KEY_category_PRIMARY", Category.CATEGORY.ID);
        public static final UniqueKey<CurrencyInfoRecord> KEY_CURRENCY_INFO_PRIMARY = Internal.createUniqueKey(CurrencyInfo.CURRENCY_INFO, "KEY_currency_info_PRIMARY", CurrencyInfo.CURRENCY_INFO.ID);
        public static final UniqueKey<ItemsRecord> KEY_ITEMS_PRIMARY = Internal.createUniqueKey(Items.ITEMS, "KEY_items_PRIMARY", Items.ITEMS.ID);
        public static final UniqueKey<LocationRecord> KEY_LOCATION_PRIMARY = Internal.createUniqueKey(Location.LOCATION, "KEY_location_PRIMARY", Location.LOCATION.ID);
        public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, "KEY_user_PRIMARY", User.USER.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ItemsRecord, CategoryRecord> CATEGORY_ON_ITEM_FK = Internal.createForeignKey(com.magpie.jooq.Keys.KEY_CATEGORY_PRIMARY, Items.ITEMS, "category_on_item_fk", Items.ITEMS.CAT_ID);
        public static final ForeignKey<ItemsRecord, LocationRecord> LOCATION_ON_ITEM_FK_IDX = Internal.createForeignKey(com.magpie.jooq.Keys.KEY_LOCATION_PRIMARY, Items.ITEMS, "location_on_item_fk_idx", Items.ITEMS.LOCATION_ID);
    }
}
