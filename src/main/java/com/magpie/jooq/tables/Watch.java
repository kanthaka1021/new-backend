/*
 * This file is generated by jOOQ.
 */
package com.magpie.jooq.tables;


import com.magpie.jooq.Indexes;
import com.magpie.jooq.Keys;
import com.magpie.jooq.Magpie;
import com.magpie.jooq.tables.records.WatchRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
public class Watch extends TableImpl<WatchRecord> {

    private static final long serialVersionUID = -1965678082;

    /**
     * The reference instance of <code>magpie.watch</code>
     */
    public static final Watch WATCH = new Watch();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WatchRecord> getRecordType() {
        return WatchRecord.class;
    }

    /**
     * The column <code>magpie.watch.id</code>.
     */
    public final TableField<WatchRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>magpie.watch.item_id</code>.
     */
    public final TableField<WatchRecord, Integer> ITEM_ID = createField(DSL.name("item_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>magpie.watch.user_id</code>.
     */
    public final TableField<WatchRecord, Integer> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>magpie.watch</code> table reference
     */
    public Watch() {
        this(DSL.name("watch"), null);
    }

    /**
     * Create an aliased <code>magpie.watch</code> table reference
     */
    public Watch(String alias) {
        this(DSL.name(alias), WATCH);
    }

    /**
     * Create an aliased <code>magpie.watch</code> table reference
     */
    public Watch(Name alias) {
        this(alias, WATCH);
    }

    private Watch(Name alias, Table<WatchRecord> aliased) {
        this(alias, aliased, null);
    }

    private Watch(Name alias, Table<WatchRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Watch(Table<O> child, ForeignKey<O, WatchRecord> key) {
        super(child, key, WATCH);
    }

    @Override
    public Schema getSchema() {
        return Magpie.MAGPIE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.WATCH_PRIMARY);
    }

    @Override
    public Identity<WatchRecord, Integer> getIdentity() {
        return Keys.IDENTITY_WATCH;
    }

    @Override
    public UniqueKey<WatchRecord> getPrimaryKey() {
        return Keys.KEY_WATCH_PRIMARY;
    }

    @Override
    public List<UniqueKey<WatchRecord>> getKeys() {
        return Arrays.<UniqueKey<WatchRecord>>asList(Keys.KEY_WATCH_PRIMARY);
    }

    @Override
    public Watch as(String alias) {
        return new Watch(DSL.name(alias), this);
    }

    @Override
    public Watch as(Name alias) {
        return new Watch(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Watch rename(String name) {
        return new Watch(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Watch rename(Name name) {
        return new Watch(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
