package br.com.medeja.funcional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class ProdutorTest {

	@Test
	void delega_para_metodo_produzir() {
		Supplier<String> supplier = Produtor.newSupplier(() -> "um texto qualquer");
		assertEquals("um texto qualquer", supplier.get());
	}
	
	@Test
	void converte_exception_em_runtime_exception() {
		Supplier<String> supplier = Produtor.newSupplier(() -> {throw new Exception("um erro qualquer");});
		RuntimeException exception = assertThrows(RuntimeException.class, supplier::get);
		assertEquals("java.lang.Exception: um erro qualquer", exception.getMessage());
	}

}
