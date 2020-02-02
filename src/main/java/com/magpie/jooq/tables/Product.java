/*
 * This file is generated by jOOQ.
 */
package com.magpie.jooq.tables;


import com.magpie.jooq.Indexes;
import com.magpie.jooq.Keys;
import com.magpie.jooq.Magpie;
import com.magpie.jooq.tables.records.ProductRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Product extends TableImpl<ProductRecord> {

    private static final long serialVersionUID = -861770902;

    /**
     * The reference instance of <code>magpie.product</code>
     */
    public static final Product PRODUCT = new Product();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductRecord> getRecordType() {
        return ProductRecord.class;
    }

    /**
     * The column <code>magpie.product.id</code>.
     */
    public final TableField<ProductRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>magpie.product.content</code>.
     */
    public final TableField<ProductRecord, String> CONTENT = createField(DSL.name("content"), org.jooq.impl.SQLDataType.VARCHAR(1000).nullable(false), this, "");

    /**
     * The column <code>magpie.product.title</code>.
     */
    public final TableField<ProductRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>magpie.product.seller_id</code>.
     */
    public final TableField<ProductRecord, Integer> SELLER_ID = createField(DSL.name("seller_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>magpie.product.pandp</code>.
     */
    public final TableField<ProductRecord, Integer> PANDP = createField(DSL.name("pandp"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>magpie.product.price</code>.
     */
    public final TableField<ProductRecord, Integer> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>magpie.product</code> table reference
     */
    public Product() {
        this(DSL.name("product"), null);
    }

    /**
     * Create an aliased <code>magpie.product</code> table reference
     */
    public Product(String alias) {
        this(DSL.name(alias), PRODUCT);
    }

    /**
     * Create an aliased <code>magpie.product</code> table reference
     */
    public Product(Name alias) {
        this(alias, PRODUCT);
    }

    private Product(Name alias, Table<ProductRecord> aliased) {
        this(alias, aliased, null);
    }

    private Product(Name alias, Table<ProductRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Product(Table<O> child, ForeignKey<O, ProductRecord> key) {
        super(child, key, PRODUCT);
    }

    @Override
    public Schema getSchema() {
        return Magpie.MAGPIE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRODUCT_FK44KNFT22LEM6QRS5A2DD3WTFG, Indexes.PRODUCT_PRIMARY);
    }

    @Override
    public Identity<ProductRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PRODUCT;
    }

    @Override
    public UniqueKey<ProductRecord> getPrimaryKey() {
        return Keys.KEY_PRODUCT_PRIMARY;
    }

    @Override
    public List<UniqueKey<ProductRecord>> getKeys() {
        return Arrays.<UniqueKey<ProductRecord>>asList(Keys.KEY_PRODUCT_PRIMARY);
    }

    @Override
    public List<ForeignKey<ProductRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ProductRecord, ?>>asList(Keys.FK44KNFT22LEM6QRS5A2DD3WTFG);
    }

    public User user() {
        return new User(this, Keys.FK44KNFT22LEM6QRS5A2DD3WTFG);
    }

    @Override
    public Product as(String alias) {
        return new Product(DSL.name(alias), this);
    }

    @Override
    public Product as(Name alias) {
        return new Product(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(String name) {
        return new Product(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(Name name) {
        return new Product(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, Integer, Integer, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
