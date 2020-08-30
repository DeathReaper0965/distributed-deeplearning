package com.distributedDL.streaming.core;

import java.io.Serializable;

import org.apache.flink.streaming.api.functions.co.RichCoFlatMapFunction;

@SuppressWarnings("serial")
public abstract class Joiner<X, Y, Z> extends RichCoFlatMapFunction<X, Y, Z> implements Serializable{

}
