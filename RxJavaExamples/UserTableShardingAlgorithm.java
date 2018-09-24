package com.livedrof.shardingjdbc.algorithm;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

public class UserTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    private static final int SHARDING_NUMBER = 16;

    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        for (String each : collection) {
            if (each.endsWith(preciseShardingValue.getValue() % SHARDING_NUMBER + "")) {
                System.out.println(each);
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
