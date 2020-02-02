/*
 * This file is generated by jOOQ.
 */
package com.magpie.jooq.tables;


import com.magpie.jooq.Indexes;
import com.magpie.jooq.Keys;
import com.magpie.jooq.Magpie;
import com.magpie.jooq.tables.records.CategoryRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class Category extends TableImpl<CategoryRecord> {

    private static final long serialVersionUID = 12909774;

    /**
     * The reference instance of <code>magpie.category</code>
     */
    public static final Category CATEGORY = new Category();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CategoryRecord> getRecordType() {
        return CategoryRecord.class;
    }

    /**
     * The column <code>magpie.category.id</code>.
     */
    public final TableField<CategoryRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>magpie.category.is_leaf</code>.
     */
    public final TableField<CategoryRecord, String> IS_LEAF = createField(DSL.name("is_leaf"), org.jooq.impl.SQLDataType.CHAR(1).nullable(false).defaultValue(org.jooq.impl.DSL.inline("N", org.jooq.impl.SQLDataType.CHAR)), this, "");

    /**
     * The column <code>magpie.category.name</code>.
     */
    public final TableField<CategoryRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>magpie.category.parent_id</code>.
     */
    public final TableField<CategoryRecord, Integer> PARENT_ID = createField(DSL.name("parent_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>magpie.category</code> table reference
     */
    public Category() {
        this(DSL.name("category"), null);
    }

    /**
     * Create an aliased <code>magpie.category</code> table reference
     */
    public Category(String alias) {
        this(DSL.name(alias), CATEGORY);
    }

    /**
     * Create an aliased <code>magpie.category</code> table reference
     */
    public Category(Name alias) {
        this(alias, CATEGORY);
    }

    private Category(Name alias, Table<CategoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Category(Name alias, Table<CategoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Category(Table<O> child, ForeignKey<O, CategoryRecord> key) {
        super(child, key, CATEGORY);
    }

    @Override
    public Schema getSchema() {
        return Magpie.MAGPIE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CATEGORY_PRIMARY);
    }

    @Override
    public Identity<CategoryRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CATEGORY;
    }

    @Override
    public UniqueKey<CategoryRecord> getPrimaryKey() {
        return Keys.KEY_CATEGORY_PRIMARY;
    }

    @Override
    public List<UniqueKey<CategoryRecord>> getKeys() {
        return Arrays.<UniqueKey<CategoryRecord>>asList(Keys.KEY_CATEGORY_PRIMARY);
    }

    @Override
    public Category as(String alias) {
        return new Category(DSL.name(alias), this);
    }

    @Override
    public Category as(Name alias) {
        return new Category(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Category rename(String name) {
        return new Category(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Category rename(Name name) {
        return new Category(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
