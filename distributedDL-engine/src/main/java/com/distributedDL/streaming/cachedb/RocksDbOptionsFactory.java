package com.distributedDL.streaming.cachedb;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.contrib.streaming.state.ConfigurableOptionsFactory;
import org.apache.flink.contrib.streaming.state.OptionsFactory;
import org.rocksdb.BlockBasedTableConfig;
import org.rocksdb.ColumnFamilyOptions;
import org.rocksdb.DBOptions;

@SuppressWarnings({ "serial", "deprecation" })
public class RocksDbOptionsFactory implements ConfigurableOptionsFactory{
	
	private final static long DEFAULT_SIZE = 256 * 1024 * 1024;
	private static long blockCacheSize = DEFAULT_SIZE;
	

	@Override
	public DBOptions createDBOptions(DBOptions currentOptions) {
		return currentOptions.setIncreaseParallelism(4)
							 .setUseFsync(false);
	}

	@Override
	public ColumnFamilyOptions createColumnOptions(ColumnFamilyOptions currentOptions) {
		return currentOptions.setTableFormatConfig(
										new BlockBasedTableConfig().setBlockCacheSize(blockCacheSize)
																   .setBlockSize(128 * 1024));
	}

	@Override
	public OptionsFactory configure(Configuration configuration) {
		blockCacheSize = configuration.getLong("my.custom.rocksdb.block.cache.size", DEFAULT_SIZE);
		return this;
	}

}
