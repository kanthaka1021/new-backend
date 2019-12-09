package com.magpie.repository;


import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableRecord;

import reactor.core.publisher.Mono;

public interface InsertRepository<T1 extends Record, T2 extends Table<T1>> {
	
	default Mono<T1> insertMono(DSLContext dsl, T1 t1, T2 t2) {
		try {
			dsl.insertInto(t2).set(t1).execute();
			return Mono.just(t1);
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.error(e);
		}
	}	
	
	default Mono<Long> insertMonoWitUpdateCount(DSLContext dsl, T1 t1, T2 t2) {
		try {
			dsl.insertInto(t2).set(t1).execute();
			return Mono.just(1L);
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.error(e);
		}
	}	
	
	default Mono<T1> insertMonoOnDuplicated(DSLContext dsl, T1 t1, T1 t2, T2 t3) {
		try {
			dsl.insertInto(t3).set(t1).onDuplicateKeyUpdate().set(t2).execute();
			return Mono.just(t1);
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.error(e);
		}
	}	
	
	default Optional<T1> insertOptionalOnDuplicated(DSLContext dsl, T1 t1, T1 t2, T2 t3) {
		try {
			dsl.insertInto(t3).set(t1).onDuplicateKeyUpdate().set(t2).execute();
			return Optional.of(t1);
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}			
	
	default Mono<T1> insertMonoReturning(DSLContext dsl, T1 t1, T2 t2, Field<?>... f) {
		try {
			T1 r = dsl.insertInto(t2).set(t1).returning(f).fetchOne();
			return Mono.just(r);
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.error(e);
		}
	}		
	
	default Mono<Long> insertMonoBulk(DSLContext dsl, Collection<? extends TableRecord<?>> records) {
		int[] result = dsl.batchInsert(records).execute();
		long completedCount = Arrays.stream(result).filter(s -> s == 1).count();
		return Mono.just(completedCount);
	}
	
}
