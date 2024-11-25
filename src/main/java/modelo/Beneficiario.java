package modelo;

import java.sql.Date;
import java.text.ParseException;

public class Beneficiario extends Persona implements OperacionesREST {

	private int porcentaje;
	private String clave_poliza;
	
<<<<<<< HEAD
	public Beneficiario(String nombre, String primerApellido, String segundoApellido, Calendar fechaNacimiento, int porcentaje, String clave_poliza) {
=======
	public Beneficiario(String nombre, String primerApellido, String segundoApellido, String fechaNacimiento, int porcentaje) throws ParseException {
>>>>>>> gestionDB
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

	public String getClave_poliza() {
		return clave_poliza;
	}

	public void setClave_poliza(String clave_poliza) {
		this.clave_poliza = clave_poliza;
	}
	
	
}
