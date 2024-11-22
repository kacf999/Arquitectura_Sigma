package modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Persona implements OperacionesREST{
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	
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
	
	public String getFechaNacimientoString() {
		return fechaNacimiento.toString();
	}
	
	public Date getFechaNacimientoDate() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimientoString(String fechaNacimiento) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		
		this.fechaNacimiento = new Date(sdf.parse(fechaNacimiento).getTime());
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
