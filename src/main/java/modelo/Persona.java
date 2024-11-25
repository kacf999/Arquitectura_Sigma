package modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Persona implements OperacionesREST{
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private java.sql.Date fechaNacimiento;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, String primerApellido, String segundoApellido, String fechaNacimiento) throws ParseException {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		setFechaNacimientoString(fechaNacimiento);
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
	
	public Date getFechaNacimientoDate() {
		return fechaNacimiento;
	}
	
	public String getFechaNacimientoString() {
		return fechaNacimiento.toString();
	}
	public void setFechaNacimientoString(String fechaNacimiento) {
		SimpleDateFormat formato=new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			java.util.Date fechaFormateada= formato.parse(fechaNacimiento);
			this.fechaNacimiento = new java.sql.Date(fechaFormateada.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setFechaNacimientoDate(Date fechaNacimiento) {
		this.fechaNacimiento=fechaNacimiento;
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
