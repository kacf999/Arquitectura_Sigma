package mx.edu.uacm.is.stl.as.ws.modelo;

import java.text.ParseException;
import java.util.UUID;

public class Beneficiario extends Persona implements OperacionesREST {

	private int porcentaje;
	private UUID clave_poliza;
	

	public Beneficiario(String nombre, String primerApellido, String segundoApellido, String fechaNacimiento, UUID clave_poliza, int porcentaje) throws ParseException {
		super(nombre, primerApellido, segundoApellido, fechaNacimiento);
		this.clave_poliza = clave_poliza;
		this.porcentaje = porcentaje;
	}
	
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public UUID getClave_poliza() {
		return clave_poliza;
	}

	public void setClave_poliza(UUID clave_poliza) {
		this.clave_poliza = clave_poliza;
	}
	
	
}
