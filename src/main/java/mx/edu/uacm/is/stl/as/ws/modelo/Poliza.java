package mx.edu.uacm.is.stl.as.ws.modelo;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Poliza {
	private UUID clave;
	private int tipo;
	private float monto;
	private String descripcion;
	private String curp_cliente;

	public Poliza() {
		super();
	}
	
	public Poliza(UUID clave, int tipo, float monto, String descripcion, String curp) throws ExceptionPoliza {
		this();
		this.clave = clave;
		this.tipo = tipo;
		this.monto = monto;
		this.descripcion = descripcion;
		setCurpCliente(curp);
	}
	public UUID getClave() {
		return clave;
	}
	public void setClave(UUID clave) {
		this.clave = clave;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public boolean setCurpCliente(String curp) throws ExceptionPoliza {
		boolean exito=false;
		Pattern pattern = Pattern.compile("[A-Z]{4}[0-9]{6}[HM]{1}[A-Z]{2}[BCDFGHJKLMNPQRSTVWXYZ]{3}([A-Z]{2})?([0-9]{2})");
		
		Matcher matcher = pattern.matcher(curp);
		
		if(matcher.find()) {
			exito=true;
			curp_cliente=curp;
		}else {
			throw new ExceptionPoliza(416);
		}
		return exito;
	}
	
	
	
	public String getCurpCliente() throws ExceptionPoliza {
		if(curp_cliente.isEmpty()) {
			throw new ExceptionPoliza(404);
		}else {
			return curp_cliente;
		}
	}
	
	public void agregarBeneficiario() {}
	
	public void comprobarPorcentaje() {}
	
	public void eliminarBeneficiario() {}
	
	
}
