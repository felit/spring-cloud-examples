package com.livedrof.shardingjdbc.algorithm;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class UserDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final int TABLE_SHARDING_NUMBER = 16;
    private static final int DATABASE_SHARDING_NUMBER = 4;

    public String doSharding(final Collection<String> availableTargetNames,
                             final PreciseShardingValue<Long> shardingValue) {
        for (String each : availableTargetNames) {
            if (each.endsWith(shardingValue.getValue() %  DATABASE_SHARDING_NUMBER + "")) {
                logger.debug("the target database name: {}", each);
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

}
