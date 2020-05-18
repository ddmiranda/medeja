package br.com.medeja.funcional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ExecutanteTest {

	@Test
	void delega_para_metodo_consumir() {
		boolean[] delegou = new boolean[] {false};
		Runnable runnable = Executante.newSupplier(() -> {delegou[0] = true;});
		runnable.run();
		assertTrue(delegou[0]);
	}
	
	@Test
	void converte_exception_em_runtime_exception() {
		Runnable runnable = Executante.newSupplier(() -> {throw new Exception("um erro qualquer");});
		RuntimeException exception = assertThrows(RuntimeException.class, () -> runnable.run());
		assertEquals("java.lang.Exception: um erro qualquer", exception.getMessage());
	}

}
