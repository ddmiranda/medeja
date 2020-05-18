package br.com.medeja.funcional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

class ConsumidorTest {

	@Test
	void delega_para_metodo_consumir() {
		boolean[] delegou = new boolean[] {false};
		Consumer<String> consumer = Consumidor.newConsumer((texto) -> {delegou[0] = true;});
		consumer.accept("qualquer Coisa");
		assertTrue(delegou[0]);
	}
	
	@Test
	void converte_exception_em_runtime_exception() {
		Consumer<String> consumer = Consumidor.newConsumer((texto) -> {throw new Exception(texto);});
		RuntimeException exception = assertThrows(RuntimeException.class, () -> consumer.accept("um erro qualquer"));
		assertEquals("java.lang.Exception: um erro qualquer", exception.getMessage());
	}

}
