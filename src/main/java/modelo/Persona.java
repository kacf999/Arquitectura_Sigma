package modelo;

import java.util.Calendar;

public class Persona implements OperacionesREST{
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Calendar fechaNacimiento;
	public Persona(String nombre, String primerApellido, String segundoApellido, Calendar fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public void get() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void put() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void post() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	
}
