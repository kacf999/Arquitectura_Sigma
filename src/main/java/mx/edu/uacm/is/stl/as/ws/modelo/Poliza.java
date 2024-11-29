package mx.edu.uacm.is.stl.as.ws.modelo;

import java.util.UUID;

@Entity
public class Poliza {
	private UUID clave;
	private int tipo;
	private float monto;
	private String descripcion;

	public Poliza() {
		super();
	}
	
	public Poliza(UUID clave, int tipo, float monto, String descripcion) {
		this();
		this.clave = clave;
		this.tipo = tipo;
		this.monto = monto;
		this.descripcion = descripcion;
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

	
	public void agregarBeneficiario() {}
	
	public void comprobarPorcentaje() {}
	
	public void eliminarBeneficiario() {}
	
	
}
