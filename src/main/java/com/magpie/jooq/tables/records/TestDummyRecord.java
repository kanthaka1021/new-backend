/*
 * This file is generated by jOOQ.
 */
package com.magpie.jooq.tables.records;


import com.magpie.jooq.tables.TestDummy;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class TestDummyRecord extends UpdatableRecordImpl<TestDummyRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -561704566;

    /**
     * Setter for <code>magpie.TEST_DUMMY.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>magpie.TEST_DUMMY.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>magpie.TEST_DUMMY.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>magpie.TEST_DUMMY.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>magpie.TEST_DUMMY.email</code>.
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>magpie.TEST_DUMMY.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TestDummy.TEST_DUMMY.ID;
    }

    @Override
    public Field<String> field2() {
        return TestDummy.TEST_DUMMY.NAME;
    }

    @Override
    public Field<String> field3() {
        return TestDummy.TEST_DUMMY.EMAIL;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public TestDummyRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TestDummyRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public TestDummyRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public TestDummyRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TestDummyRecord
     */
    public TestDummyRecord() {
        super(TestDummy.TEST_DUMMY);
    }

    /**
     * Create a detached, initialised TestDummyRecord
     */
    public TestDummyRecord(Integer id, String name, String email) {
        super(TestDummy.TEST_DUMMY);

        set(0, id);
        set(1, name);
        set(2, email);
    }
}
