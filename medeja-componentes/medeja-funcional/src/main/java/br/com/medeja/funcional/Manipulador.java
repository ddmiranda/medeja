package br.com.medeja.funcional;

public interface Manipulador<T> extends Tradutor<T, T> {
	
	T manipular(T t) throws Exception ;
	
	@Override
	default T traduzir(T t) throws Exception {
		return manipular(t);
	}

}
