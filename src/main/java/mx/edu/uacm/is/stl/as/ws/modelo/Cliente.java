package mx.edu.uacm.is.stl.as.ws.modelo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

public class Cliente extends Persona {
	private String direccion;
	private String curp;
	private ArrayList<Poliza> polizas;
	
	
	public Cliente() {
		super();
		polizas=new ArrayList<Poliza>();
	}
	
	public Cliente(String nombre, String primerApellido, String segundoApellido, String fechaNacimiento,
			String direccion, String curp) throws ParseException {
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
	
	public boolean addPoliza(Poliza poliza) {
		boolean exito=false;
		Optional<Poliza> vacio=Optional.of(poliza);
		
		if(vacio.isPresent()) {
			polizas.add(poliza);
			exito=true;
		}
		
		return exito;
	}
	
}
