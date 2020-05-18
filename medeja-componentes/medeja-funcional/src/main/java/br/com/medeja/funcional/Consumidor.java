package br.com.medeja.funcional;

import java.util.function.Consumer;

public interface Consumidor<T> extends Consumer<T> {
	
	void consumir(T t) throws Exception;
	
	@Override
	default void accept(T t) {
		try {
			this.consumir(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static <V> Consumidor<V> of(Consumidor<V> consumidor){
		return consumidor;
	}
	
	static <V> Consumer<V> newConsumer(Consumidor<V> consumidor){
		return of(consumidor);
	}
	
}
