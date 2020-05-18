package br.com.medeja.funcional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ManipuladorTest {

	@Test
	void delega_para_metodo_manipular() throws Exception {		
		Manipulador<String> manipulador = (texto) -> "manipulou: " + texto;
		Tradutor<String, String> tradutor = manipulador;
		String resultado = tradutor.traduzir("qualquer coisa");
		assertEquals("manipulou: qualquer coisa", resultado);
	}

}
