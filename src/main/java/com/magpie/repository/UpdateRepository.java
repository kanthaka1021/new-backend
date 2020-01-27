package com.magpie.repository;

import java.util.Arrays;
import java.util.Collection;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.UpdatableRecord;
import org.jooq.UpdateConditionStep;

import reactor.core.publisher.Mono;

public interface UpdateRepository<T1 extends Record> {
	
	default Mono<Integer> updateMono(UpdateConditionStep<T1> step) {
		try {
			int updated = step.execute();
			if(updated > 0) {
				return Mono.just(updated);
			} else {
				return Mono.empty();
			}
		} catch (Exception e) {
			return Mono.error(e);
		}
	}	
	
	default Mono<Long> updateMonoBulk(DSLContext dsl, Collection<? extends UpdatableRecord<?>> records) {
		int[] result = dsl.batchUpdate(records).execute();
		long completedCount = Arrays.stream(result).filter(s -> s == 1).count();
		return Mono.just(completedCount);
	}	
}

