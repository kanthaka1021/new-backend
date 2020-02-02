/*
 * This file is generated by jOOQ.
 */
package com.magpie.jooq;


import com.magpie.jooq.tables.Category;
import com.magpie.jooq.tables.CategoryLevel;
import com.magpie.jooq.tables.Country;
import com.magpie.jooq.tables.ImageFile;
import com.magpie.jooq.tables.Item;
import com.magpie.jooq.tables.Location;
import com.magpie.jooq.tables.Message;
import com.magpie.jooq.tables.Product;
import com.magpie.jooq.tables.ProfileImageFile;
import com.magpie.jooq.tables.TestDummy;
import com.magpie.jooq.tables.User;
import com.magpie.jooq.tables.Watch;

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
     * The table <code>magpie.category_level</code>.
     */
    public static final CategoryLevel CATEGORY_LEVEL = CategoryLevel.CATEGORY_LEVEL;

    /**
     * The table <code>magpie.country</code>.
     */
    public static final Country COUNTRY = Country.COUNTRY;

    /**
     * The table <code>magpie.image_file</code>.
     */
    public static final ImageFile IMAGE_FILE = ImageFile.IMAGE_FILE;

    /**
     * The table <code>magpie.item</code>.
     */
    public static final Item ITEM = Item.ITEM;

    /**
     * The table <code>magpie.location</code>.
     */
    public static final Location LOCATION = Location.LOCATION;

    /**
     * The table <code>magpie.message</code>.
     */
    public static final Message MESSAGE = Message.MESSAGE;

    /**
     * The table <code>magpie.product</code>.
     */
    public static final Product PRODUCT = Product.PRODUCT;

    /**
     * The table <code>magpie.profile_image_file</code>.
     */
    public static final ProfileImageFile PROFILE_IMAGE_FILE = ProfileImageFile.PROFILE_IMAGE_FILE;

    /**
     * The table <code>magpie.user</code>.
     */
    public static final User USER = User.USER;

    /**
     * The table <code>magpie.watch</code>.
     */
    public static final Watch WATCH = Watch.WATCH;
}