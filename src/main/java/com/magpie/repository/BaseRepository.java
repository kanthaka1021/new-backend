package com.magpie.repository;

import org.jooq.*;
import org.jooq.exception.DataAccessException;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class BaseRepository<T1 extends Record, T2 extends Table<T1>, T3>{

    public String getQuery(UpdateConditionStep<T1> condition) {
        return condition.getSQL();
    }

    public Integer count(DSLContext dsl, SelectConditionStep<T1> condition) throws DataAccessException {
        return dsl.fetchCount(condition);
    }

    // Use generic type
    public  Mono<T1> fetchOne(DSLContext dsl, SelectConditionStep<T1> condition) {
        try {
            T1 t = dsl.fetchOne(condition);
            if (t == null) {
                return Mono.empty();
            } else {
                return Mono.just(t);
            }
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    // User generic type and supplier
    public Mono<T3> fetchOne(Supplier<T3> func) {
        try {
            T3 t = func.get();
            if (t == null) {
                return Mono.empty();
            } else {
                return Mono.just(t);
            }
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    // Use generic type and supplier
    public Mono<List<T3>> fetchList(Supplier<List<T3>> fun) {
        try {
            return Mono.defer(() -> {return Mono.just(fun.get());});
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    // Use only Generic type
    public Mono<Integer> insert(DSLContext dsl, T1 t1, T2 t2) {
        try {
            Integer result = dsl.insertInto(t2).set(t1).execute();
            return Mono.just(result);
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    // use generic type and supplier. This function can implement 'insert' and 'update'.
    public Mono<Integer> modify(Supplier<Integer> func) {
        try {
            Integer result = func.get();
            return Mono.just(result);
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    public Mono<Long> insertBulk(List<T3> list, Function<List<T1>, Long> func, Function<List<T3>, List<T1>> func2) {
        try {
            Long res = func.apply(func2.apply(list));
            return Mono.just(res);
        } catch(Exception e) {
            return Mono.error(e);
        }
    }

    public Long reduceInserts(int[] r) {
        return Arrays.stream(r).filter(s -> s == 1).count();
    }

}
