package com.distributedDL.streaming.core;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public abstract class Mapper<X, Y> implements MapFunction<X, Y> {
	final public ObjectMapper mapper = new ObjectMapper();
}
