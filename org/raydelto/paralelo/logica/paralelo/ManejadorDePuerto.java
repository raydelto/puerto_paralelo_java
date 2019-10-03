package org.raydelto.paralelo.logica.paralelo;

public class ManejadorDePuerto implements Runnable{
	private PuertoParalelo paralelo;
	public ManejadorDePuerto(){
		this.paralelo = new PuertoParalelo();
	}
	
	public void desplegarEnPantalla(short numero){
		short decenas = (short) (numero / 10);
		short unidades = (short)(numero % 10);
		short data = (short) (16 * decenas);
		data += unidades;
		paralelo.escribir(data);
	}
	
	public void contar(){
		Thread hiloContador = new Thread(this);
		hiloContador.start();
	}

	public void run() {
		short data;
		for(short i = 0; i <= 9 ; i++){
			for(short j = 0 ; j <= 9 ; j++ ){
				data = (short) (16 * i);
				data += j;				
				paralelo.escribir(data);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
}
