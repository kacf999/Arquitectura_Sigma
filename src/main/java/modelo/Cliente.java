package modelo;

import java.sql.Date;

public class Cliente extends Persona implements OperacionesREST {
	private String direccion;
	private String curp;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento,
			String direccion, String curp) {
		super(nombre, primerApellido, segundoApellido, fechaNacimiento);
		this.direccion = direccion;
		this.curp = curp;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	@Override
	public void get() {
		// TODO Auto-generated method stub
		super.get();
	}
	@Override
	public void put() {
		// TODO Auto-generated method stub
		super.put();
	}
	@Override
	public void post() {
		// TODO Auto-generated method stub
		super.post();
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		super.delete();
	}
	
	
	
}
