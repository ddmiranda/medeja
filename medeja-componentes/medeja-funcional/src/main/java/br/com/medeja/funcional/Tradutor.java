package br.com.medeja.funcional;

import java.util.function.Function;

public interface Tradutor<T, R> extends Function<T, R> {
	
	R traduzir(T t) throws Exception;
	
	@Override
	default R apply(T t) {
		try {
			return this.traduzir(t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static <V,Z> Tradutor<V,Z> of(Tradutor<V,Z> tradutor){
		return tradutor;
	}
	
	static <V,Z> Function<V,Z> newFunction(Tradutor<V,Z> tradutor){
		return of(tradutor);
	}
	
}
