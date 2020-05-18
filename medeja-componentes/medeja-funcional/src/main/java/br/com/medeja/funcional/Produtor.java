package br.com.medeja.funcional;

import java.util.function.Supplier;

public interface Produtor<T> extends Supplier<T>{

	T produzir() throws Exception;
	
	@Override
	default T get() {
		try {
			return this.produzir();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static <V> Produtor<V> of(Produtor<V> produtor){
		return produtor;
	}

	static <V> Supplier<V> newSupplier(Produtor<V> produtor){
		return of(produtor);
	}
	
}
