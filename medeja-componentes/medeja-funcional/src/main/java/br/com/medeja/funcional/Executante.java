package br.com.medeja.funcional;

public interface Executante extends Runnable {
	
	void executar() throws Exception;
	
	@Override
	default void run() {
		try {
			this.executar();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static Executante of(Executante excecutante){
		return excecutante;
	}

	static Runnable newSupplier(Executante executante){
		return of(executante);
	}

}
