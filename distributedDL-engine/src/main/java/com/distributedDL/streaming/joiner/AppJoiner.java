package com.distributedDL.streaming.joiner;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import com.distributedDL.streaming.cachedb.RocksDbCache;
import com.distributedDL.streaming.core.Joiner;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings({"serial"})
public abstract class AppJoiner<X, Y, Z> extends Joiner<X, Y, Z> {
	
	public static HashMap<String, RocksDbCache> cacheMap = new HashMap<String, RocksDbCache>();
	
	private ValueState<X> xState;
	private ValueState<Y> yState;
	private ValueState<Z> zState;
	
	public AppJoiner(HashMap<String, RocksDbCache> cMap) {
		cacheMap = cMap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void open(Configuration parameters) throws Exception{
		super.open(parameters);
		xState = getRuntimeContext().getState(new ValueStateDescriptor<>("save_x_state", (Class<X>) getGenericClassType(0)));
		yState = getRuntimeContext().getState(new ValueStateDescriptor<>("save_y_state", (Class<Y>) getGenericClassType(1)));
		zState = getRuntimeContext().getState(new ValueStateDescriptor<>("save_z_state", (Class<Z>) getGenericClassType(2)));
	}
	
	@Override
	public abstract void flatMap1(X xModel, Collector<Z> out) throws Exception;

	@Override
	public abstract void flatMap2(Y yModel, Collector<Z> out) throws Exception;
	
	private Type getGenericClassType(int index) {

        Type type = getClass().getGenericSuperclass();

        while (!(type instanceof ParameterizedType)) {
            if (type instanceof ParameterizedType) {
                type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
            } else {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }

        return ((ParameterizedType) type).getActualTypeArguments()[index];
    }
	
	protected void cleanAllStates() {
		this.getXState().clear();
		this.getYState().clear();
		this.getZState().clear();
	}

}
