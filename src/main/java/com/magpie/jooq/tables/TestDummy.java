/*
 * This file is generated by jOOQ.
 */
package com.magpie.jooq.tables;


import com.magpie.jooq.Indexes;
import com.magpie.jooq.Keys;
import com.magpie.jooq.Magpie;
import com.magpie.jooq.tables.records.TestDummyRecord;

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
public class TestDummy extends TableImpl<TestDummyRecord> {

    private static final long serialVersionUID = 364861810;

    /**
     * The reference instance of <code>magpie.TEST_DUMMY</code>
     */
    public static final TestDummy TEST_DUMMY = new TestDummy();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TestDummyRecord> getRecordType() {
        return TestDummyRecord.class;
    }

    /**
     * The column <code>magpie.TEST_DUMMY.id</code>.
     */
    public final TableField<TestDummyRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>magpie.TEST_DUMMY.name</code>.
     */
    public final TableField<TestDummyRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>magpie.TEST_DUMMY.email</code>.
     */
    public final TableField<TestDummyRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * Create a <code>magpie.TEST_DUMMY</code> table reference
     */
    public TestDummy() {
        this(DSL.name("TEST_DUMMY"), null);
    }

    /**
     * Create an aliased <code>magpie.TEST_DUMMY</code> table reference
     */
    public TestDummy(String alias) {
        this(DSL.name(alias), TEST_DUMMY);
    }

    /**
     * Create an aliased <code>magpie.TEST_DUMMY</code> table reference
     */
    public TestDummy(Name alias) {
        this(alias, TEST_DUMMY);
    }

    private TestDummy(Name alias, Table<TestDummyRecord> aliased) {
        this(alias, aliased, null);
    }

    private TestDummy(Name alias, Table<TestDummyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TestDummy(Table<O> child, ForeignKey<O, TestDummyRecord> key) {
        super(child, key, TEST_DUMMY);
    }

    @Override
    public Schema getSchema() {
        return Magpie.MAGPIE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TEST_DUMMY_PRIMARY);
    }

    @Override
    public Identity<TestDummyRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TEST_DUMMY;
    }

    @Override
    public UniqueKey<TestDummyRecord> getPrimaryKey() {
        return Keys.KEY_TEST_DUMMY_PRIMARY;
    }

    @Override
    public List<UniqueKey<TestDummyRecord>> getKeys() {
        return Arrays.<UniqueKey<TestDummyRecord>>asList(Keys.KEY_TEST_DUMMY_PRIMARY);
    }

    @Override
    public TestDummy as(String alias) {
        return new TestDummy(DSL.name(alias), this);
    }

    @Override
    public TestDummy as(Name alias) {
        return new TestDummy(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TestDummy rename(String name) {
        return new TestDummy(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TestDummy rename(Name name) {
        return new TestDummy(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
