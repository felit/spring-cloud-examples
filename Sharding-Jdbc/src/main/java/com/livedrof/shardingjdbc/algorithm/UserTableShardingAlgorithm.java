package com.livedrof.shardingjdbc.algorithm;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

public class UserTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    private static final int SHARDING_NUMBER = 16;
    private static final int DATABASE_SHARDING_NUMBER = 4;

    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        for (String each : collection) {
            Long val = Long.valueOf(preciseShardingValue.getValue()+"");
            //Caused by: java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Long
//            Long val = preciseShardingValue.getValue();
            if (each.endsWith(val % SHARDING_NUMBER - val % SHARDING_NUMBER / DATABASE_SHARDING_NUMBER * DATABASE_SHARDING_NUMBER + "")) {
                System.out.println(each);
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
