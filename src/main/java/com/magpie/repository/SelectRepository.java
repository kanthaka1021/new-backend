package com.magpie.repository;

import org.jooq.*;
import org.jooq.exception.DataAccessException;
import reactor.core.publisher.Mono;


public interface SelectRepository<T extends Record> {
    default String getQuery(SelectConditionStep<T> condition) {
        return condition.getSQL();
    }

    default Integer count(DSLContext dsl, SelectConditionStep<T> condition) throws DataAccessException {
        return dsl.fetchCount(condition);
    }

    default Mono<T> fetchMono(DSLContext dsl, SelectConditionStep<T> condition) {
        try {
            T t = dsl.fetchOne(condition);
            if (t == null) {
                return Mono.empty();
            } else {
                return Mono.just(t);
            }
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    default Mono<Result<T>> fetch(DSLContext dsl, SelectConditionStep<T> condition) {
        try {
            Result<T> t = dsl.fetch(condition);
            if (t == null) {
                return Mono.empty();
            } else {
                return Mono.just(t);
            }
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

}
