package org.raydelto.paralelo.logica.paralelo;
public class PuertoParalelo{
	private ParaleloNativo nativo;
	private short direccion;
	{
		this.nativo = new ParaleloNativo();
	}
	public PuertoParalelo(short direccion) {
		super();		
		this.direccion = direccion;
	}

	public PuertoParalelo(){
		this.direccion = 0x378;		
	}
	public void escribir(short data){
		nativo.Out32(direccion,data);
	}
	
	public short leer(){
		return nativo.Inp32(direccion);
	}
   
}

