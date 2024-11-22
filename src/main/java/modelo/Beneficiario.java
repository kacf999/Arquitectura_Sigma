package modelo;

import java.sql.Date;
import java.text.ParseException;

public class Beneficiario extends Persona implements OperacionesREST {

	private int porcentaje;
	
	public Beneficiario(String nombre, String primerApellido, String segundoApellido, String fechaNacimiento, int porcentaje) throws ParseException {
		super(nombre, primerApellido, segundoApellido, fechaNacimiento);
		
		this.porcentaje = porcentaje;
	}
	
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
}
