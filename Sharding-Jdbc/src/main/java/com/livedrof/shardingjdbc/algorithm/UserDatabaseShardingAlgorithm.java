package com.livedrof.shardingjdbc.algorithm;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class UserDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final long TABLE_SHARDING_NUMBER = 16L;
    private static final long DATABASE_SHARDING_NUMBER = 4L;

    public String doSharding(final Collection<String> availableTargetNames,
                             final PreciseShardingValue<Long> shardingValue) {
        for (String each : availableTargetNames) {
            Long val =  (Long.valueOf(shardingValue.getValue()+"") % TABLE_SHARDING_NUMBER) / DATABASE_SHARDING_NUMBER;
            if (each.endsWith(val + "")) {
                logger.debug("the target database name: {}", each);
                System.out.println(each);
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

}
