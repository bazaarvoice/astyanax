package com.netflix.astyanax;

public enum CassandraOperationType {
    BATCH_MUTATE, GET_ROW, GET_ROWS_RANGE, GET_ROWS_SLICE, GET_ROWS_BY_INDEX, GET_COLUMN, CQL, DESCRIBE_RING, COUNTER_MUTATE, COLUMN_MUTATE, COLUMN_DELETE, COLUMN_INSERT, GET_COLUMN_COUNT, COPY_TO, DESCRIBE_KEYSPACE, TRUNCATE, DESCRIBE_CLUSTER, DESCRIBE_VERSION, DESCRIBE_SNITCH, DESCRIBE_PARTITIONER, DESCRIBE_SCHEMA_VERSION, GET_VERSION, DROP_COLUMN_FAMILY, DESCRIBE_KEYSPACES, DROP_KEYSPACE, ADD_COLUMN_FAMILY, UPDATE_COLUMN_FAMILY, ADD_KEYSPACE, UPDATE_KEYSPACE, SET_KEYSPACE, DESCRIBE_SPLITS, TEST,
}
