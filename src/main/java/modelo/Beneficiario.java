package modelo;

import java.sql.Date;

public class Beneficiario extends Persona implements OperacionesREST {

	private int porcentaje;
	
	public Beneficiario(String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, int porcentaje) {
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
