package br.com.medeja.funcional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

class TradutorTest {

	@Test
	void delega_para_metodo_traduzir() {
		Function<Integer, String> function = Tradutor.newFunction((numero) -> "um texto qualquer numero: " + numero);
		assertEquals("um texto qualquer numero: 30", function.apply(30));
	}
	
	@Test
	void converte_exception_em_runtime_exception() {
		Function<Integer, String> function = Tradutor.newFunction((numero) -> {throw new Exception("um erro qualquer");});
		RuntimeException exception = assertThrows(RuntimeException.class, () -> function.apply(21));
		assertEquals("java.lang.Exception: um erro qualquer", exception.getMessage());
	}

}
